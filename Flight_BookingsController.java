package com.ss.utopia.controller;


import com.ss.utopia.entity.Airplane_Type;
import com.ss.utopia.entity.Flight_Bookings;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.Flight_BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class Flight_BookingsController {
    @Autowired
    Flight_BookingsService flight_BookingsService;

    @RequestMapping(path = "/lms/flight_booking/{fid}{bid}", method = RequestMethod.GET)
    public Flight_Bookings getBooking_GuestByBookingID(@PathVariable int fid, @PathVariable int bid){
        return flight_BookingsService.getFlight_BookingsByIDS(fid, bid);
    }
    // create
    @RequestMapping(path = "/lms/flight_booking", method = RequestMethod.POST)
    public void addAirplane_Type(@RequestBody Flight_Bookings fb){
        try {
            flight_BookingsService.addFlight_Booking(fb);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/flight_booking", method = RequestMethod.PATCH)
    public void updateAirplane_TypeByID(@RequestBody Flight_Bookings[] fb){
        try {
            flight_BookingsService.updateFlight_Booking(fb[0], fb[1]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/flight_booking", method = {RequestMethod.DELETE})
    public void deleteAirplane_TypeByID(@RequestBody Flight_Bookings fb){
        try {
            flight_BookingsService.deleteFlight_Booking(fb);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
