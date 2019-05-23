package com.cxing.userserver.service;


import com.cxing.userserver.model.User;

public interface UserService {

    int saveUser(User user);

    User queryUser(User user);

}
