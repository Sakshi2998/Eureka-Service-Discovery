package com.example.bookratingservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookratingservice.models.Rating;
import com.example.bookratingservice.models.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingsResource {

	@GetMapping("/{id}")
	Rating getRating(@PathVariable int id) {
		return new Rating(id, 4);
	}

	@GetMapping("/user/{userId}")
	UserRating getUserRating(@PathVariable String userId) {
		List<Rating> ratingList = new ArrayList<>();
		ratingList.add(new Rating(1, 4));
		ratingList.add(new Rating(2, 1));
		ratingList.add(new Rating(4, 3));
		ratingList.add(new Rating(3, 5));
		ratingList.add(new Rating(6, 3));
		ratingList.add(new Rating(5, 4));
		return new UserRating(ratingList);
	}

}
