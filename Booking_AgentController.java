package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Booking_Agent;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.Booking_AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class Booking_AgentController {
    @Autowired
    Booking_AgentService booking_agentService;

    // read
    @RequestMapping(path = "/lms/booking_agent/{id}", method = RequestMethod.GET)
    public Booking_Agent getBooking_AgentByBookingID(@PathVariable int id){
        return booking_agentService.getBooking_AgentByBookingID(id);
    }
    // create
    @RequestMapping(path = "/lms/booking_agent", method = RequestMethod.POST)
    public void addBooking_Agent(@RequestBody Booking_Agent ba){
        try {
            booking_agentService.addBookingAgent(ba);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/booking_agent", method = RequestMethod.PATCH)
    public void updateBooking_Agent(@RequestBody Booking_Agent ba){
        try {
            booking_agentService.updateBookingAgent(ba);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // delete
    @RequestMapping(path = "/lms/booking_agent", method = RequestMethod.DELETE)
    public void deleteBooking_Agent(@RequestBody Booking_Agent ba){
        try {
            booking_agentService.deleteBookingAgent(ba);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
