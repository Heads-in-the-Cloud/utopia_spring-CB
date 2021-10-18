package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane_Type;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;

    //read
    @RequestMapping(path = "/lms/booking/{id}", method = RequestMethod.GET)
    public Booking getBookingByID(@PathVariable int id){
        return bookingService.getBookingByID(id);
    }
    // create
    @RequestMapping(path = "/lms/booking", method = RequestMethod.POST)
    public Integer addBooking(@RequestBody Booking b){
        Integer id = null;
        try {
            id = bookingService.addBooking(b);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }
    // update
    @RequestMapping(path = "/lms/booking", method = RequestMethod.PATCH)
    public void updateBookingByID(@RequestBody Booking b){
        try {
            bookingService.updateBooking(b);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/booking", method = {RequestMethod.DELETE})
    public void deleteBookingByID(@RequestBody Booking b){
        try {
            bookingService.deleteBooking(b);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
