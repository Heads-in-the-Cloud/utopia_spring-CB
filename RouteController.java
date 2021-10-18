package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane_Type;
import com.ss.utopia.entity.Route;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class RouteController {
    @Autowired
    RouteService routeService;

    // read
    @RequestMapping(path = "/lms/route/{id}", method = RequestMethod.GET)
    public Route getRouteByID(@PathVariable int id){
        return routeService.getRouteByID(id);
    }
    // create
    @RequestMapping(path = "/lms/route", method = RequestMethod.POST)
    public void addRoute(@RequestBody Route r){
        try {
            routeService.addRoute(r);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/route", method = RequestMethod.PATCH)
    public void updateRoute(@RequestBody Route r){
        try {
            routeService.updateRoute(r);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/route", method = {RequestMethod.DELETE})
    public void deleteRoute(@RequestBody Route r){
        try {
            routeService.deleteRoute(r);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
