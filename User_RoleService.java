package com.ss.utopia.service;

import com.ss.utopia.dao.User_RoleDAO;
import com.ss.utopia.entity.User_Role;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class User_RoleService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public User_Role getUser_RoleByID(int id) {
        try {
            return readUserRoles("SELECT * FROM user_role WHERE id = ?", new Object[]{id}).get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User_Role> readUserRoles(String sql, Object[] param) throws SQLException, ClassNotFoundException{
        Connection conn = connUtil.getConnection();
        try {
            User_RoleDAO urDAO = new User_RoleDAO(conn);
            ArrayList<User_Role> all= (ArrayList<User_Role>) urDAO.read(sql, param);
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
    public Integer addUser_Role(User_Role ur) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            User_RoleDAO urDAO = new User_RoleDAO(conn);
            Integer ret = urDAO.saveWithPK("INSERT INTO user_role SET name =  ?", (new Object[] {ur.getName()}));
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
    public Boolean deleteUser_Role(User_Role ur) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            User_RoleDAO urDAO = new User_RoleDAO(conn);
            urDAO.save("DELETE FROM user_role WHERE id = ?", new Object[]{ur.getId()});
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
    public Boolean updateUser_Role(User_Role ur) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            User_RoleDAO urDAO = new User_RoleDAO(conn);
            urDAO.save("UPDATE user_role SET name = ? WHERE id = ?", (new Object[] {ur.getName(), ur.getId()}));
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
