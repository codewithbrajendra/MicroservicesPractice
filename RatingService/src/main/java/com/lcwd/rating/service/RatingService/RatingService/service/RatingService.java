package com.lcwd.rating.service.RatingService.RatingService.service;


import com.lcwd.rating.service.RatingService.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);

}
