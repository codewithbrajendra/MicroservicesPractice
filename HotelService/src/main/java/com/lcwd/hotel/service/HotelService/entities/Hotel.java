package com.lcwd.hotel.service.HotelService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}
