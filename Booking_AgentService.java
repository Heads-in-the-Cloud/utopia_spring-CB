package com.ss.utopia.service;

import com.ss.utopia.dao.Booking_AgentDAO;
import com.ss.utopia.entity.Booking_Agent;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Booking_AgentService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public List<Booking_Agent> readBookingAgents(String sql, Object[] param) throws SQLException, ClassNotFoundException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_AgentDAO baDAO = new Booking_AgentDAO(conn);
            ArrayList<Booking_Agent> all= (ArrayList<Booking_Agent>) baDAO.read(sql, param);
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


    public Booking_Agent getBooking_AgentByBookingID(int id){
        List<Booking_Agent> bookingAgents = null;
        try {
            bookingAgents = readBookingAgents("SELECT * FROM booking_agent WHERE booking_id = ?", new Object[]{id});
            return bookingAgents.get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean addBookingAgent(Booking_Agent ba) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_AgentDAO baDAO = new Booking_AgentDAO(conn);
            System.out.println(ba.toString());
            baDAO.save("INSERT INTO booking_agent SET booking_id = (SELECT id FROM booking WHERE id = ?)," +
                            "agent_id = (SELECT id FROM user WHERE id = ?)",
                    (new Object[] { ba.getBooking_ID(), ba.getAgent_ID()}));
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

    public Boolean updateBookingAgent(Booking_Agent ba) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_AgentDAO baDAO = new Booking_AgentDAO(conn);
            baDAO.save("UPDATE booking_agent SET agent_id = (SELECT id FROM user WHERE id = ?)" +
                            "WHERE booking_id = (SELECT id FROM booking WHERE id = ?)",
                    (new Object[] {ba.getAgent_ID(), ba.getBooking_ID()}));
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

    public Boolean deleteBookingAgent(Booking_Agent ba) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Booking_AgentDAO baDAO = new Booking_AgentDAO(conn);
            baDAO.save("DELETE FROM booking_agent WHERE booking_id = ?", new Object[]{ba.getBooking_ID()});
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
