package com.tuqi.controller;

import com.tuqi.domain.model.UserDO;
import com.tuqi.manager.UserManager;
import com.tuqi.util.MyMD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Xianrui Ke on 2017/4/12.
 */

@Controller
@RequestMapping("user")
public class UserBaseController {
    @Autowired
    UserManager userManager;

    //用户注册
    @RequestMapping("userRegister")
    public String userRegister(@RequestParam String userName,@RequestParam String password,@RequestParam(required = false) String nickName,
                               @RequestParam(required = false) String userPosition){
        UserDO userDO = new UserDO();
        if(StringUtils.isNotBlank(userName)){
            userDO.setUserName(userName);
        }
        if(StringUtils.isNotBlank(password)){
            try {
                userDO.setPassword(MyMD5Util.getEncryptedPwd(password));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if(StringUtils.isNotBlank(nickName)){
            userDO.setUserNickName(nickName);
        }
        if(StringUtils.isNotBlank(userPosition)){
            userDO.setUserPosition(userPosition);
        }

        userManager.insertSelective(userDO);
        return "user/login";
    }
}
