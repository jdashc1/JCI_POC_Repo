package com.user.service;

import com.netflix.discovery.converters.Auto;
import com.user.service.entities.Rating;
import com.user.service.external.services.RatingService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {

	}

//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(10).userId("").ratingId("").hotelId("").feedback("This is created using Feign client").build();
//		ResponseEntity<Rating> saverating = ratingService.createRating(rating);
//		saverating.getStatusCode();
//		saverating.getBody();
//		saverating.getHeaders();
//		System.out.println("new rating created");
//	}

}
