package com.ss.utopia.service;

import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.entity.Booking;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public List<Booking> readBookings(String sql, Object[] param) throws SQLException, ClassNotFoundException{
        Connection conn = connUtil.getConnection();
        try {
            BookingDAO bDAO = new BookingDAO(conn);
            ArrayList<Booking> all= (ArrayList<Booking>) bDAO.read(sql, param);
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

    public Booking getBookingByID(int id) {
        List<Booking> bookings = null;
        try {
            bookings = readBookings("SELECT * FROM booking WHERE id = ?", new Object[]{id});
            return bookings.get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
    public Integer addBooking(Booking b) throws ClassNotFoundException, SQLException  {
        Connection conn = connUtil.getConnection();
        try {
            BookingDAO bDAO = new BookingDAO(conn);
            int ret = bDAO.saveWithPK("INSERT INTO booking SET is_active = ?, confirmation_code = ?",
                    (new Object[] { ((b.getIsActive())?1:0), b.getConfirmation_Code()}));
            conn.commit();
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            if(conn!=null) {
                conn.rollback();
            }
            return null;
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
    public Boolean deleteBooking(Booking b) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            BookingDAO bDAO = new BookingDAO(conn);
            bDAO.save("DELETE FROM booking WHERE id = ?", new Object[]{b.getId()});
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
    public Boolean updateBooking(Booking b) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            BookingDAO bDAO = new BookingDAO(conn);
            System.out.println(b.getIsActive());
            bDAO.save("UPDATE booking SET is_active = ?, confirmation_code = ? WHERE id = ?",
                    (new Object[] {((b.getIsActive() == true)?1:0), b.getConfirmation_Code(), b.getId() }));
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
