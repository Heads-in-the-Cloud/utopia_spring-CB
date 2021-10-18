package com.ss.utopia.controller;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class AirportController {

    @Autowired
    AirportService airportService;

    // read
    @RequestMapping(path = "/lms/airport/{iata}", method = RequestMethod.GET)
    public Airport getAirportByIATA(@PathVariable String iata){
        return airportService.getAirportByIATA(iata);
    }
    // create
    @RequestMapping(path = "/lms/airport", method = RequestMethod.POST)
    public void addAirport(@RequestBody Airport a){
        try {
            airportService.addAirport(a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // update
    @RequestMapping(path = "/lms/airport", method = RequestMethod.PATCH)
    public void updateAirport(@RequestBody Airport[] a){
        try {
            airportService.updateAirport(a[0], a[1]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // delete
    @RequestMapping(path = "/lms/airport", method = RequestMethod.DELETE)
    public void deleteAirport(@RequestBody Airport a){
        try {
            airportService.deleteAirport(a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
