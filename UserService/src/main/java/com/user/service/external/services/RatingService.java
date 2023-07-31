package com.user.service.external.services;
import com.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
  //get

  //post
  //ResponseEntity to get the data and information.
  @PostMapping("/ratings")
  public ResponseEntity<Rating> createRating(Rating values);

  //put
  @PutMapping("/ratings/{ratingId}")
  public ResponseEntity<Rating> updateRating(@PathVariable String ratingId,Rating rating);

  //Delete Rating
  @DeleteMapping("/ratings/{ratingId}")
  public void deleteRating(@PathVariable("ratingId") String ratingId);

}
