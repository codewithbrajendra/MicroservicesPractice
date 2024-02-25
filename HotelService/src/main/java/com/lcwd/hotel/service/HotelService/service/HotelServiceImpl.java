package com.lcwd.hotel.service.HotelService.service;

import com.lcwd.hotel.service.HotelService.entities.Hotel;
import com.lcwd.hotel.service.HotelService.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lcwd.hotel.service.HotelService.repositories.HotelRepository;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        if(hotel != null) {
            String uuid = UUID.randomUUID().toString();
            hotel.setId(uuid);
            Hotel createdHotel = hotelRepository.save(hotel);
            return createdHotel;
        }
        return null;
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id is not found : "+hotelId));
    }
}
