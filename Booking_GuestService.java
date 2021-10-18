package com.ss.utopia.service;

import com.ss.utopia.dao.Booking_AgentDAO;
import com.ss.utopia.dao.Booking_GuestDAO;
import com.ss.utopia.entity.Booking_Guest;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Booking_GuestService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public List<Booking_Guest> readBookingGuests(String sql, Object[] param) throws SQLException, ClassNotFoundException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_GuestDAO buDAO = new Booking_GuestDAO(conn);
            ArrayList<Booking_Guest> all= (ArrayList<Booking_Guest>) buDAO.read(sql, param);
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
    public Booking_Guest getBooking_GuestByBookingID(int id) {
        List<Booking_Guest> bookingGuests = null;
        try {
            bookingGuests = readBookingGuests("SELECT * FROM booking_guest WHERE booking_id = ?", new Object[]{id});
            return bookingGuests.get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Boolean addBookingGuest(Booking_Guest bg) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_GuestDAO bgDAO = new Booking_GuestDAO(conn);
            bgDAO.save("INSERT INTO booking_guest SET booking_id = (SELECT id FROM booking WHERE id = ?)," +
                            "contact_email = ?, contact_phone = ?",
                    (new Object[] { bg.getBooking_ID(), bg.getContact_email(), bg.getContact_Phone()}));
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
    public Boolean deleteBookingGuest(Booking_Guest bg) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_GuestDAO bgDAO = new Booking_GuestDAO(conn);
            bgDAO.save("DELETE FROM booking_guest WHERE booking_id = ?", new Object[]{bg.getBooking_ID()});
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
    public Boolean updateBookingGuest(Booking_Guest bg) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_GuestDAO bgDAO = new Booking_GuestDAO(conn);
            bgDAO.save("UPDATE booking_guest SET contact_email = ?, contact_phone = ? " +
                            "WHERE booking_id = (SELECT id FROM booking WHERE id = ?)",
                    (new Object[] {bg.getContact_email(), bg.getContact_Phone(), bg.getBooking_ID()}));
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
