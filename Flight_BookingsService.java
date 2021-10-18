package com.ss.utopia.service;

import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.dao.Flight_BookingsDAO;
import com.ss.utopia.entity.Flight_Bookings;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Flight_BookingsService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public Flight_Bookings getFlight_BookingsByIDS(int fid, int bid) {
        List<Flight_Bookings> flightBookings = null;
        try {
            flightBookings = readFlightBookings("SELECT * FROM flight_bookings", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for(Flight_Bookings fb: flightBookings){
            if(fb.getFlight_ID() == fid && fb.getBooking_ID() == bid){
                return fb;
            }
        }
        return null;
    }

    public List<Flight_Bookings> readFlightBookings(String sql, Object[] param) throws SQLException, ClassNotFoundException {
        Connection conn = connUtil.getConnection();
        try {
            Flight_BookingsDAO fbDAO = new Flight_BookingsDAO(conn);
            ArrayList<Flight_Bookings> all= (ArrayList<Flight_Bookings>) fbDAO.read(sql, param);
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
    public Boolean addFlight_Booking(Flight_Bookings fb) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            BookingDAO bDAO = new BookingDAO(conn);
            bDAO.save("INSERT INTO flight_bookings SET flight_id = ?, booking_id = ?", (new Object[] { fb.getFlight_ID(), fb.getBooking_ID()}));
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
    public Boolean deleteFlight_Booking(Flight_Bookings fb) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Flight_BookingsDAO fbDAO = new Flight_BookingsDAO(conn);
            fbDAO.save("DELETE FROM flight_bookings WHERE flight_id = ? AND booking_id = ?",
                    new Object[]{fb.getFlight_ID(), fb.getBooking_ID()});
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
    public Boolean updateFlight_Booking(Flight_Bookings original, Flight_Bookings updated) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Flight_BookingsDAO fbDAO = new Flight_BookingsDAO(conn);
            fbDAO.save("UPDATE flight_bookings SET flight_id = ?, booking_id = ? " +
                            "WHERE flight_id = ? AND booking_id = ?",
                    (new Object[] {updated.getFlight_ID(), updated.getBooking_ID(),
                            original.getFlight_ID(), original.getBooking_ID()}));
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
