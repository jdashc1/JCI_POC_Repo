package com.user.service.external.services;

import com.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
  //Declarative aaproach
  @GetMapping("/hotel/{hotelId}")
  public Hotel getHotel(@PathVariable("hotelId") String hotelId);

}
