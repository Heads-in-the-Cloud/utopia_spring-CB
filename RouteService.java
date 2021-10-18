package com.ss.utopia.service;

import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.entity.Route;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public List<Route> readRoutes(String sql, Object[] param) throws SQLException, ClassNotFoundException {
        Connection conn = connUtil.getConnection();
        try {
            RouteDAO rDAO = new RouteDAO(conn);
            ArrayList<Route> all= (ArrayList<Route>) rDAO.read(sql, param);
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
    public Integer addRoute(Route r) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            RouteDAO rDAO = new RouteDAO(conn);
            System.out.print(r.toString());
            Integer ret = rDAO.saveWithPK("INSERT INTO route SET origin_id = (SELECT iata_id FROM airport WHERE iata_id = ?),"
                    + "destination_id = (SELECT iata_id FROM airport WHERE iata_id = ?)", (new Object[] {r.getOrigin_ID(), r.getDestination_ID()}));
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
    public Boolean deleteRoute(Route r) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            RouteDAO rDAO = new RouteDAO(conn);
            rDAO.save("DELETE FROM route WHERE origin_id = ? AND destination_id = ?",  new Object[] {r.getOrigin_ID(), r.getDestination_ID()});
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
    public Boolean updateRoute(Route r) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            RouteDAO rDAO = new RouteDAO(conn);
            rDAO.save("UPDATE route SET origin_id = (SELECT iata_id FROM airport WHERE iata_id = ?)," +
                            "destination_id = (SELECT iata_id FROM airport WHERE iata_id = ?) WHERE id = ?",
                    (new Object[] {r.getOrigin_ID(), r.getDestination_ID(), r.getId()}));
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

    public Route getRouteByID(int id) {
        try {
            return readRoutes("SELECT * FROM route WHERE id = ?", new Object[]{id}).get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
