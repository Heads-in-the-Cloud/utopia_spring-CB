package com.ss.utopia.service;

import com.ss.utopia.dao.Booking_UserDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.entity.Booking_User;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Booking_UserService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public List<Booking_User> readBookingUsers(String sql, Object[] param) throws SQLException, ClassNotFoundException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_UserDAO buDAO = new Booking_UserDAO(conn);
            ArrayList<Booking_User> all= (ArrayList<Booking_User>) buDAO.read(sql, param);
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
    public Boolean addBooking_User(Booking_User bu) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_UserDAO buDAO = new Booking_UserDAO(conn);
            buDAO.save("INSERT INTO booking_user SET booking_id = ?, user_id = ?",
                    (new Object[] { bu.getBooking_ID(), bu.getUser_ID()}));
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
    public Boolean deleteBooking_User(Booking_User bu) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_UserDAO buDAO = new Booking_UserDAO(conn);
            buDAO.save("DELETE FROM booking_user WHERE booking_id = ?", new Object[]{bu.getBooking_ID()});
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
    public Boolean updateBooking_User(Booking_User bu) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_UserDAO buDAO = new Booking_UserDAO(conn);
            buDAO.save("UPDATE booking_user SET user_id = (SELECT id FROM user WHERE id = ?)" +
                            "WHERE booking_id = (SELECT id FROM booking WHERE id = ?)",
                    (new Object[] {bu.getUser_ID(), bu.getBooking_ID()}));
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

    public Booking_User getBooking_UserByBookingID(int id) {
        List<Booking_User> bookingUsers = null;
        try {
            bookingUsers = readBookingUsers("SELECT * FROM booking_user", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for(Booking_User bu: bookingUsers){
            if(bu.getBooking_ID() == id){
                return bu;
            }
        }
        return null;
    }
}
