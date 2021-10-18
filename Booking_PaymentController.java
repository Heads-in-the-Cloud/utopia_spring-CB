package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane_Type;
import com.ss.utopia.entity.Booking_Payment;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.Booking_PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class Booking_PaymentController {
    @Autowired
    Booking_PaymentService booking_PaymentService;

    @RequestMapping(path = "/lms/booking_payment/{id}", method = RequestMethod.GET)
    public Booking_Payment getBooking_PaymentByBookingID(@PathVariable int id){
        return booking_PaymentService.getBooking_PaymentByBookingID(id);
    }
    // create
    @RequestMapping(path = "/lms/booking_payment", method = RequestMethod.POST)
    public void addBooking_Payment(@RequestBody Booking_Payment bp){
        try {
            booking_PaymentService.addBooking_Payment(bp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/booking_payment", method = RequestMethod.PATCH)
    public void updateBooking_Payment(@RequestBody Booking_Payment bp){
        try {
            booking_PaymentService.updateBooking_Payment(bp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/booking_payment", method = {RequestMethod.DELETE})
    public void deleteBooking_Payment(@RequestBody Booking_Payment bp){
        try {
            booking_PaymentService.deleteBooking_Payment(bp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
