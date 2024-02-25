package com.lcwd.user.service.UserService.service;

import com.lcwd.user.service.UserService.entities.Hotel;
import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.UserService.externals.HotelService;
import com.lcwd.user.service.UserService.externals.RatingService;
import com.lcwd.user.service.UserService.repositories.UserRepositories;
import org.hibernate.usertype.ParameterizedType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private RestClient restClient;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User createUser(User user) {
        if(user != null) {
            String userId = UUID.randomUUID().toString();
            user.setUserId(userId);
            User createdUser = userRepositories.save(user);
//            Hotel hotel = Hotel.builder().name("Marine").location("Mumbai").about("This is Marine Hotel.").build();
//            Hotel savedHotel = hotelService.saveHotel(hotel); //Post api for save hotel
//            System.out.println("SavedHotel : "+savedHotel);
            return createdUser;
        }
        return null;
    }

    @Override
    public User findByUserId(String userId) {
        if(userId != null) {
            User user = userRepositories.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server : "+userId));

//            List<Rating> ratingsOfUser = restClient.get().uri("http://localhost:9093/ratings/users/"+user.getUserId())
//                    .retrieve().body(new ParameterizedTypeReference<List<Rating>>() {});

            List<Rating> ratingsOfUser = ratingService.getRatingByUserId(user.getUserId());

            System.out.println("ratingsOfUser : "+ratingsOfUser);
            List<Rating> ratingList = ratingsOfUser.stream().map(rating -> {
//                        Hotel hotel = restClient.get().uri("http://localhost:9092/hotel/"+rating.getHotelId())
//                                .retrieve().body(Hotel.class);
                       Hotel hotel = hotelService.getHotel(rating.getHotelId());
                        rating.setHotel(hotel);
                        return rating;
                    }).collect(Collectors.toList());
            user.setRatings(ratingsOfUser);
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositories.findAll();
    }
}
