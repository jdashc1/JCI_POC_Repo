package com.lcwd.rating.repository;

import com.lcwd.rating.entities.Rating;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableMongoRepositories(basePackages = "com.lcwd.rating.repository")

public interface RatingRepository extends MongoRepository<Rating,String> {

List<Rating> findByUserId(String userId);
List<Rating> findByHotelId(String hotelId);


}
