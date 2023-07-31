package com.user.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_user")
public class User {

    @Id
    @Column(name = "UserID")
    private String UID;
    @Column(name = "firstname")
    private String FirstName;

    @Column(name = "email")
    private String Email;

    @Column(name = "mobile")
    private int mobileNo;

    public void setUserId(String randomUserId) {
        this.UID = randomUserId;
    }
    @Transient//transient means compiler will not save ratings in database
    private List<Rating> ratings = new ArrayList<>();
}
