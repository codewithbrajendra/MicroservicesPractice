package com.lcwd.hotel.service.HotelService.controller;

import com.lcwd.hotel.service.HotelService.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lcwd.hotel.service.HotelService.service.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/createHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hotelId));
    }

    @GetMapping("/getHotels")
    public ResponseEntity<List<Hotel>> getHotels() {
        return ResponseEntity.ok(hotelService.getAllHotel());
    }

}
