package com.tuqi.controller;

import com.tuqi.domain.model.UserDO;
import com.tuqi.domain.query.UserQuery;
import com.tuqi.manager.UserManager;
import com.tuqi.util.MyMD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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
    public String userRegister(@RequestParam String rUsename,@RequestParam String rPasswd,@RequestParam(required = false) String rNickname,
                               @RequestParam(required = false) String rPosition){
        UserDO userDO = new UserDO();
        if(StringUtils.isNotBlank(rUsename)){
            userDO.setUserName(rUsename);
        }
        if(StringUtils.isNotBlank(rPasswd)){
            userDO.setPassword(MyMD5Util.code(rPasswd));
        }
        if(StringUtils.isNotBlank(rNickname)){
            userDO.setUserNickName(rNickname);
        }
        if(StringUtils.isNotBlank(rPosition)){
            userDO.setUserPositionId(Integer.parseInt(rPosition));
        }

        userManager.insertSelective(userDO);
        return "/loginAndRegister";
    }
    //用户登录
    @RequestMapping("userLogin")
    public String userLogin(@RequestParam String usernameInput, @RequestParam String passwdInput){
        if(StringUtils.isNotBlank(usernameInput)){
            UserQuery userQuery = new UserQuery();
            userQuery.createCriteria().andUserNameEqualTo(usernameInput);
            List<UserDO> userDOList = userManager.selectByQuery(userQuery);
            if(StringUtils.isNotBlank(passwdInput)){
                String mdPwd = MyMD5Util.code(passwdInput);
                if(userDOList.get(0).getPassword().equals(mdPwd)){
                    return "/index";
                }
            }
        }
        return "";
    }
}
