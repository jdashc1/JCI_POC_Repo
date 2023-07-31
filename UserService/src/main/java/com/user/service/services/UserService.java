package com.user.service.services;

import com.user.service.entities.User;

import java.util.List;
//https://www.youtube.com/watch?v=C8NZpYQtlho

public interface UserService {

    User saveUser(User user);

    User getUser(String userId);

    List<User> getAllUser();

//deleete
    //update

}
