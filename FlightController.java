package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane_Type;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class FlightController {
    @Autowired
    FlightService flightService;

    @RequestMapping(path = "/lms/flight/{id}", method = RequestMethod.GET)
    public Flight getFlightByID(@PathVariable int id){
        return flightService.getFlightByID(id);
    }
    // create
    @RequestMapping(path = "/lms/flight", method = RequestMethod.POST)
    public void addFlight(@RequestBody Flight f){
        try {
            flightService.addFlight(f);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/flight", method = RequestMethod.PATCH)
    public void updateFlight(@RequestBody Flight[] f){
        try {
            flightService.updateFlight(f[0], f[1]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/flight", method = {RequestMethod.DELETE})
    public void deleteFlight(@RequestBody Flight f){
        try {
            flightService.deleteFlight(f);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
