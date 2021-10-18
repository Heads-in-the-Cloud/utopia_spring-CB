package com.ss.utopia.service;

import com.ss.utopia.dao.Booking_PaymentDAO;
import com.ss.utopia.entity.Booking_Payment;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Booking_PaymentService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public List<Booking_Payment> readBookingPayments(String sql, Object[] param) throws SQLException, ClassNotFoundException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_PaymentDAO bpDAO = new Booking_PaymentDAO(conn);
            ArrayList<Booking_Payment> all= (ArrayList<Booking_Payment>) bpDAO.read(sql, param);
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

    public Booking_Payment getBooking_PaymentByBookingID(int id) {
        List<Booking_Payment> bookingPayments = null;
        try {
            bookingPayments = readBookingPayments("SELECT * FROM booking_payment", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for(Booking_Payment bp: bookingPayments){
            if (bp.getBooking_ID() == id){
                return bp;
            }
        }
        return null;
    }
    public Boolean addBooking_Payment(Booking_Payment bp) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_PaymentDAO bpDAO = new Booking_PaymentDAO(conn);
            bpDAO.save("INSERT INTO booking_payment SET booking_id = ?, stripe_id = ?, refunded = ?",
                    (new Object[] { bp.getBooking_ID(), bp.getStripe_ID(), (bp.getRefunded()?1:0)}));
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
    public Boolean deleteBooking_Payment(Booking_Payment bp) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_PaymentDAO bpDAO = new Booking_PaymentDAO(conn);
            bpDAO.save("DELETE FROM booking_payment WHERE booking_id = ?", new Object[]{bp.getBooking_ID()});
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
    public Boolean updateBooking_Payment(Booking_Payment bp) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_PaymentDAO bpDAO = new Booking_PaymentDAO(conn);
            bpDAO.save("UPDATE booking_payment SET stripe_id = ?, refunded = ? WHERE booking_id = " +
                            "(SELECT id FROM booking WHERE id = ?)",
                    (new Object[] {bp.getStripe_ID(), bp.getRefunded(), bp.getBooking_ID()}));
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
