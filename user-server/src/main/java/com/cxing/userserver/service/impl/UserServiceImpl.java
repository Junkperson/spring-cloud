package com.cxing.userserver.service.impl;



import com.cxing.userserver.model.User;
import com.cxing.userserver.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public int saveUser(User user){

        return 1;
    }

    @Override
    public User queryUser(User user) {
        if(user.getId() == 1){
            user.setName("我是一号");
        }else {
            user.setName("我是其他号");
        }
        return user;
    }

}
