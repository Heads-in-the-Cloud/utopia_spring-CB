package com.ss.utopia.service;

import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.entity.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {
    //ConnectionUtil connUtil = new ConnectionUtil();

    @Autowired
    Connection conn;



    public List<Airport> readAirports(String sql, Object[] param) throws SQLException, ClassNotFoundException{
        //Connection conn = connUtil.getConnection();
        try {
            AirportDAO aDAO = new AirportDAO(conn);
            ArrayList<Airport> all= (ArrayList<Airport>) aDAO.read(sql, param);
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


    public Airport getAirportByIATA(String iata) {
        List<Airport> airports = null;
        try {
            airports = readAirports("Select * FROM airport", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(Airport a: airports){
            if(a.getIata_ID().equals(iata)){
                return a;
            }
        }
        return null;
    }
    public Boolean addAirport(Airport a) throws ClassNotFoundException, SQLException {
        //Connection conn = connUtil.getConnection();
        try {
            AirportDAO aDAO = new AirportDAO(conn);
            aDAO.save("INSERT INTO airport VALUES (?, ?)", (new Object[] {a.getIata_ID(), a.getCity()}));
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
    public Boolean updateAirport(Airport original, Airport updated) throws ClassNotFoundException, SQLException {
        //Connection conn = connUtil.getConnection();
        try {
            AirportDAO aDAO = new AirportDAO(conn);
            aDAO.save("UPDATE airport SET iata_id = ?, city = ? WHERE iata_id = ?",
                    new Object[]{updated.getIata_ID(), updated.getCity(), original.getIata_ID()});
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
    public Boolean deleteAirport(Airport a) throws ClassNotFoundException, SQLException {
        //Connection conn = connUtil.getConnection();
        try {
            AirportDAO aDAO = new AirportDAO(conn);
            aDAO.save("DELETE FROM airport WHERE iata_id = ?", new Object[] {a.getIata_ID()});
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
