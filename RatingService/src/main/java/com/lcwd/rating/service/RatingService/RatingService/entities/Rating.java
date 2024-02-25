package com.lcwd.rating.service.RatingService.RatingService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
