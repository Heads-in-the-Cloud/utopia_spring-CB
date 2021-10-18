package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Airplane_Type;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class AirplaneController {
    @Autowired
    AirplaneService airplaneService;

    // read
    @RequestMapping(path = "/lms/airplane/{id}", method = RequestMethod.GET)
    public Airplane getAirplaneByID(@PathVariable int id){
        return airplaneService.getAirplaneByID(id);
    }
    // create
    @RequestMapping(path = "/lms/airplane", method = RequestMethod.POST)
    public void addAirplane(@RequestBody Airplane a){
        try {
            airplaneService.addAirplane(a.getType_id());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/airplane", method = RequestMethod.PATCH)
    public void updateAirplane(@RequestBody Airplane a){
        try {
            airplaneService.updateAirplane(a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // delete
    @RequestMapping(path = "/lms/airplane", method = RequestMethod.DELETE)
    public void deleteAirplane(@RequestBody Airplane a){
        try {
            airplaneService.deleteAirplane(a.getId());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
