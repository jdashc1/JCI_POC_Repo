package com.lcwd.hotel.Impl;

import com.lcwd.hotel.Exception.ResourceNotFoundException;
import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.services.HotelService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceImpl implements HotelService {

  @Autowired
  private HotelRepository hotelRepository;

  @Override
  public Hotel create(Hotel hotel) {
    String hotelId = UUID.randomUUID().toString();
    System.out.println(hotelId+"Chinmayee is testing hotelId");
    hotel.setId(hotelId);
    return hotelRepository.save(hotel);
  }

  @Override
  public List<Hotel> getAll() {
    return hotelRepository.findAll();
  }

  @Override
  public Hotel get(String id) {
    return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found!!"));
  }
}
