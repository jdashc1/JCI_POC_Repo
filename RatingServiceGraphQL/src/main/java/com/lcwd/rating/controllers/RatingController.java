package com.lcwd.rating.controllers;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.services.RatingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {
  @Autowired
  private RatingService ratingService;

  //creating rating service
  @PostMapping
  public ResponseEntity<Rating> create(@RequestBody Rating rating){
    return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
  }
  //get all rating services

  @GetMapping
  public ResponseEntity<List<Rating>> getRatings(){
    return  ResponseEntity.ok(ratingService.getAllRatings());
  }
//
  @GetMapping("/user/{userId}")
public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
  return  ResponseEntity.ok(ratingService.getAllRatingsByUserId(userId));
}

@GetMapping("/hotels/{hotelId}")
  public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
    return  ResponseEntity.ok(ratingService.getAllRatingsByHotelId(hotelId));
  }
}
