package com.user.service.Impl;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.external.services.HotelService;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import org.springframework.web.client.RestTemplate;
//pending is hostname ans port number
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
   private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        System.out.println(randomUserId+"randomUserId");
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }
    @Override
    public User getUser(String userid) {
        User user =  userRepository.findById(userid).orElseThrow(()-> new ResourceNotFoundException("user on the given id is not found!!"+userid));
      //fetch rating of the above user from rating service//localhost:8082
      Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getUID(),Rating[].class);
      logger.info("{}",ratingOfUser);
      List<Rating> ratingval =  Arrays.stream(ratingOfUser).toList();
      List<Rating> ratingList = ratingval.stream().map(rating -> {
      // api call to hotel service to get the hotel details// http://localhost:8098/hotel/0511371a-97d1-4455-b285-e637ad53a0eb
      //ResponseEntity<Hotel> hotelObject = restTemplate.getForEntity("http://localhost:8098/hotel/"+rating.getHotelId(),Hotel.class);
      //Hotel hotelbody = hotelObject.getBody();
      //logger.info("{}",hotelObject.getStatusCode());
        Hotel hotel = hotelService.getHotel(rating.getHotelId());
      //set the hotel rating
        rating.setHotel(hotel);
      //return the rating
        return rating;
      }).collect(Collectors.toList());
      user.setRatings(ratingList);
      return user;
    }
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
