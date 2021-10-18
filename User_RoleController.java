package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane_Type;
import com.ss.utopia.entity.User_Role;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.User_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class User_RoleController {
    @Autowired
    User_RoleService user_RoleService;

    // read
    @RequestMapping(path = "/lms/user_role/{id}", method = RequestMethod.GET)
    public User_Role getAirportByIATA(@PathVariable int id){
        return user_RoleService.getUser_RoleByID(id);
    }
    // create
    @RequestMapping(path = "/lms/user_role", method = RequestMethod.POST)
    public void addUser_Role(@RequestBody User_Role ur){
        try {
            user_RoleService.addUser_Role(ur);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/user_role", method = RequestMethod.PATCH)
    public void updateUser_Role(@RequestBody User_Role ur){
        try {
            user_RoleService.updateUser_Role(ur);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/user_role", method = {RequestMethod.DELETE})
    public void deleteUser_Role(@RequestBody User_Role ur){
        try {
            user_RoleService.deleteUser_Role(ur);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
