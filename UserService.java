package com.ss.utopia.service;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.entity.User;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public User getUserByID(int id) {
        try {
            return readUsers("SELECT * FROM user WHERE id = ?", new Object[]{id}).get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<User> readUsers(String sql, Object[] param) throws SQLException, ClassNotFoundException{
        Connection conn = connUtil.getConnection();
        try {
            UserDAO uDAO = new UserDAO(conn);
            ArrayList<User> all= (ArrayList<User>) uDAO.read(sql, param);
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
    public Boolean addUser(User u) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            FlightDAO fDAO = new FlightDAO(conn);
            Integer id = fDAO.saveWithPK("INSERT INTO user SET  role_id = (SELECT id FROM user_role WHERE id = ?)," +
                            "given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ?",
                    (new Object[] {u.getRole_ID(), u.getGiven_Name(), u.getFamily_Name(), u.getUsername(), u.getEmail(),
                            u.getPassword(), u.getPhone()}));
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
    public Boolean deleteUser(User u)  throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            UserDAO uDAO = new UserDAO(conn);
            uDAO.save("DELETE FROM user WHERE id = ?",new Object[]{u.getId()});
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
    public Boolean updateUser(User u) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            UserDAO uDAO = new UserDAO(conn);
            uDAO.save("UPDATE user SET role_id = (SELECT id FROM user_role WHERE id = ?), given_name = ?," +
                            "family_name = ?, username = ?, email = ?, password = ?, phone =? WHERE id = ?",
                    (new Object[] {u.getRole_ID(), u.getGiven_Name(), u.getFamily_Name(), u.getUsername(), u.getEmail(),
                            u.getPassword(), u.getPhone(), u.getId()}));
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
