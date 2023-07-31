package com.lcwd.hotel.controllers;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController1 {


  //spring will inject HotelService details
  @Autowired
  private HotelService hotelService;


  @PreAuthorize("hasAuthority('Admin')")
  @PostMapping
  public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
    Hotel hotel1 = hotelService.create(hotel);
    return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
  }

  @PreAuthorize("hasAuthority('SCOPE_internal')")
  @GetMapping("/{hotelId}")
  public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){//get single
    return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
  }

  //Get all
  @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
  @GetMapping
  public ResponseEntity<List<Hotel>> getAll(){
    return ResponseEntity.ok(hotelService.getAll());
  }

}
