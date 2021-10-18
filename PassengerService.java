package com.ss.utopia.service;


import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.entity.Passenger;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public Passenger getPassengerByID(int id) {
        List<Passenger> passengers = null;
        try {
            passengers = readPassengers("SELECT * FROM passenger", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for(Passenger p : passengers){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public List<Passenger> readPassengers(String sql, Object[] param) throws SQLException, ClassNotFoundException{
        Connection conn = connUtil.getConnection();
        try {
            PassengerDAO pDAO = new PassengerDAO(conn);
            ArrayList<Passenger> all= (ArrayList<Passenger>) pDAO.read(sql, param);
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
    public Boolean addPassenger(Passenger p) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            PassengerDAO pDAO = new PassengerDAO(conn);
            pDAO.saveWithPK("INSERT INTO passenger SET  booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address = ?",
                    (new Object[] {p.getBooking_ID(), p.getGiven_Name(), p.getFamily_Name(), p.getDob(), p.getGender(), p.getAddress()}));
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
    public Boolean deletePassenger(Passenger p)  throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            PassengerDAO pDAO = new PassengerDAO(conn);
            pDAO.save("DELETE FROM passenger WHERE id = " + "'" + p.getId() + "'", null);
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
    public Boolean updatePassenger(Passenger p)  throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            PassengerDAO pDAO = new PassengerDAO(conn);
            pDAO.save("UPDATE passenger SET booking_id = (SELECT id FROM booking WHERE id = ?)," +
                            "given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? WHERE id = ?",
                    (new Object[] {p.getBooking_ID(), p.getGiven_Name(), p.getFamily_Name(), p.getDob(), p.getGender(),
                            p.getAddress(), p.getId()}));
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
