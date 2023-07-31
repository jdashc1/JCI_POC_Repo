package com.lcwd.rating.services;

import com.lcwd.rating.entities.Rating;
import java.util.List;

public interface RatingService {

  //create Rating
  Rating create(Rating rating);

  //Get all Ratings
  List<Rating> getAllRatings();

  //Get Rating based on User ID
  List<Rating> getAllRatingsByUserId(String userId);

  //Get all ratings by Hotel
  List<Rating> getAllRatingsByHotelId(String hotelId);
}
