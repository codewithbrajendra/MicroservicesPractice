package com.lcwd.hotel.service.HotelService.service;

import com.lcwd.hotel.service.HotelService.entities.Hotel;

import java.util.List;


public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel getHotel(String hotelId);

}
