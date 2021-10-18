package com.ss.utopia.service;


import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.entity.Flight;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public Flight getFlightByID(int id) {
        List<Flight> flights = null;
        try {
            flights = readFlights("SELECT * FROM flight", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Flight f: flights){
            if(f.getId() == id){
                return f;
            }
        }
        return null;
    }

    public List<Flight> readFlights(String sql, Object[] param) throws SQLException, ClassNotFoundException {
        Connection conn = connUtil.getConnection();
        try {
            FlightDAO fDAO = new FlightDAO(conn);
            ArrayList<Flight> all= (ArrayList<Flight>) fDAO.read(sql, param);
            return all;
        } catch (Exception e) {
            e.printStackTrace();
            if(conn!=null) {
                conn.rollback();
            }
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
        return null;
    }
    public Boolean addFlight(Flight f) throws ClassNotFoundException, SQLException  {
        Connection conn = connUtil.getConnection();
        try {
            FlightDAO fDAO = new FlightDAO(conn);
            fDAO.save("INSERT INTO flight SET id = ?, route_id = (SELECT id FROM route WHERE id = ?),"
                            + "airplane_id = (SELECT id FROM airplane WHERE id = ?),"
                            + "departure_time = ?, reserved_seats = ?, seat_price = ?",
                    (new Object[] {f.getId(), f.getRoute_ID(), f.getAirplane_ID(),
                            f.getDeparture_Time().toLocalDate() +  " " + f.getDeparture_Time().toLocalTime(),
                            f.getReservedSeats(), f.getseatPrice()}));
            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if(conn!=null) {
                conn.rollback();
            }
            return false;
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
    public Boolean updateFlight(Flight f1, Flight f2) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            FlightDAO fDAO = new FlightDAO(conn);
            fDAO.save("UPDATE flight SET id = ?, route_id = (SELECT id FROM route WHERE id = ?),"
                            + "airplane_id = (SELECT id FROM airplane WHERE id = ?),"
                            + "departure_time = ?, reserved_seats = ?, seat_price = ? WHERE id = ?",
                    (new Object[] {f2.getId(), f2.getRoute_ID(), f2.getAirplane_ID(),
                            f2.getDeparture_Time().toLocalDate() + " " + f2.getDeparture_Time().toLocalTime(),
                            f2.getReservedSeats(), f2.getseatPrice(), f1.getId()}));
            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if(conn!=null) {
                conn.rollback();
            }
            return false;
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
    public Boolean deleteFlight(Flight f)  throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            FlightDAO fDAO = new FlightDAO(conn);
            fDAO.save("DELETE FROM flight WHERE id = ?", new Object[]{f.getId()});
            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if(conn!=null) {
                conn.rollback();
            }
            return false;
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
}
