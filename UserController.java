package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane_Type;
import com.ss.utopia.entity.User;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    // read
    @RequestMapping(path = "/lms/user/{id}", method = RequestMethod.GET)
    public User getAirportByIATA(@PathVariable int id){
        return userService.getUserByID(id);
    }
    // create
    @RequestMapping(path = "/lms/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User u){
        try {
            userService.addUser(u);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/user", method = RequestMethod.PATCH)
    public void updateUser(@RequestBody User u){
        try {
            userService.updateUser(u);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/user", method = {RequestMethod.DELETE})
    public void deleteUser(@RequestBody User u){
        try {
            userService.deleteUser(u);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
