package com.lcwd.user.service.UserService.externals;

import com.lcwd.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingByUserId(@PathVariable("userId") String userId);
}
