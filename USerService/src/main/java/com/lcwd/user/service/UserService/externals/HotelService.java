package com.lcwd.user.service.UserService.externals;

import com.lcwd.user.service.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

    @PostMapping("/hotel/createHotel")
    Hotel saveHotel(Hotel hotel);
}
