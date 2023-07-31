package com.lcwd.rating.services.Impl;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.services.RatingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;



@Service
public class RatingServiceImpl implements RatingService {

  @Autowired
  private RatingRepository ratingRepository;

  @Override
  public Rating create(Rating rating) {
    return ratingRepository.save(rating);
  }

  @Override
  public List<Rating> getAllRatings() {
    return ratingRepository.findAll();
  }

  @Override
  public List<Rating> getAllRatingsByUserId(String userId) {
    return ratingRepository.findByUserId(userId);
  }

  @Override
  public List<Rating> getAllRatingsByHotelId(String hotelId) {
    return ratingRepository.findByHotelId(hotelId);
  }
}
