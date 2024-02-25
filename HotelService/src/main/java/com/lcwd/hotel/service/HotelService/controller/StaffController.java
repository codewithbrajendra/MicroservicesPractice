package com.lcwd.hotel.service.HotelService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping("/getStaffs")
    public ResponseEntity<List<String>> getstaffs(){
        List<String> staffs = Arrays.asList("Ramesh","Dinesh","Rony","Julie","Minakshi");
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }
}
