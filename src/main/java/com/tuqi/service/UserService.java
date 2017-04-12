package com.tuqi.service;

import com.tuqi.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Xianrui Ke on 2017/4/12.
 */
@Service
public class UserService {

    @Autowired
    UserManager userManager;
}
