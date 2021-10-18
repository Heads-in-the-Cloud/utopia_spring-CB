package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane_Type;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    //read
    @RequestMapping(path = "/lms/passenger/{id}", method = RequestMethod.GET)
    public Passenger getPassengerByID(@PathVariable int id){
        return passengerService.getPassengerByID(id);
    }
    // create
    @RequestMapping(path = "/lms/passenger", method = RequestMethod.POST)
    public void addPassenger(@RequestBody Passenger p){
        try {
            passengerService.addPassenger(p);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/passenger", method = RequestMethod.PATCH)
    public void updatePassenger(@RequestBody Passenger p){
        try {
            passengerService.updatePassenger(p);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/passenger", method = {RequestMethod.DELETE})
    public void deletePassenger(@RequestBody Passenger p){
        try {
            passengerService.deletePassenger(p);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
