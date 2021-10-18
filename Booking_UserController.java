package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane_Type;
import com.ss.utopia.entity.Booking_User;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.Booking_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class Booking_UserController {
    @Autowired
    Booking_UserService booking_UserService;

    @RequestMapping(path = "/lms/booking_user/{id}", method = RequestMethod.GET)
    public Booking_User getBooking_GuestByBookingID(@PathVariable int id){
        return booking_UserService.getBooking_UserByBookingID(id);
    }
    // create
    @RequestMapping(path = "/lms/booking_user", method = RequestMethod.POST)
    public void addAirplane_Type(@RequestBody Booking_User bu){
        try {
            booking_UserService.addBooking_User(bu);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/booking_user", method = RequestMethod.PATCH)
    public void updateAirplane_TypeByID(@RequestBody Booking_User bu){
        try {
            booking_UserService.updateBooking_User(bu);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/booking_user", method = {RequestMethod.DELETE})
    public void deleteAirplane_TypeByID(@RequestBody Booking_User bu){
        try {
            booking_UserService.deleteBooking_User(bu);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
