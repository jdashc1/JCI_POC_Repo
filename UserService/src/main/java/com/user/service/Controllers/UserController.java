package com.user.service.Controllers;

import com.user.service.entities.User;
import com.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User user1 = userService.saveUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user1);
  }
  //Single User Get

  int retryCount = 1;
  @GetMapping("/{userId}")
  //@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
  @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
  public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
    logger.info("Get single user handler: usercontroller");
    logger.info("retry count {}",retryCount);
    retryCount++;
    User user = userService.getUser(userId);
    return ResponseEntity.ok(user);
  }
  public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
    //logger.info("fall back is executed because service is down:",ex.getMessage());
    User user = User.builder().Email("Dummy@gmail.com").FirstName("Dummy").
            UID("1234656").build();
    return new ResponseEntity<>(user,HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> alluser = userService.getAllUser();
    return ResponseEntity.ok(alluser);
  }
}
