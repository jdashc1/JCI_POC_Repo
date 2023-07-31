package com.lcwd.hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {

  @Id
  @Column(name = "HotelID")
  private String UID;
//  @Id
//  private String id;
  private String name;
  private String location;
  private String about;

  public void setId(String randomUserId) {
    this.UID = randomUserId;
  }

}
