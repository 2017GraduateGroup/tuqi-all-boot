package com.tuqi.controller;

import com.tuqi.domain.model.UserDO;
import com.tuqi.domain.query.UserQuery;
import com.tuqi.manager.UserManager;
import com.tuqi.util.MyMD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Xianrui Ke on 2017/4/12.
 */

@Controller
@RequestMapping("user")
@Slf4j
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
        //设置默认的用户角色-普通角色
        userDO.setUserType(0);
        userManager.insertSelective(userDO);
        return "/loginAndRegister";
    }

    //用户登录
    @ResponseBody
    @RequestMapping("userLogin")
    public Integer userLogin(@RequestParam String usernameInput, @RequestParam String passwdInput, HttpServletRequest request){
        if(StringUtils.isNotBlank(usernameInput)){
            UserQuery userQuery = new UserQuery();
            userQuery.createCriteria().andUserNameEqualTo(usernameInput).andPasswordEqualTo(passwdInput);
            List<UserDO> userDOList = userManager.selectByQuery(userQuery);
            if(userDOList.size() > 0){
                request.getSession().setAttribute("currentUserId", userDOList.get(0).getUserId());
                return 1;
            }else{
                return 0;
            }
        }
        return 0;
    }

    //获取所有的用户信息
    @ResponseBody
    @RequestMapping("getAllUserInfo")
    public List getAllUserInfo(){
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andUserIdIsNotNull();
        List<UserDO> userDOList = userManager.selectByQuery(userQuery);
        return userDOList;
    }

    //修改用户信息
    @RequestMapping("updateUserInfo")
    public void updateUserInfo(@RequestParam String userId,String userName, String nickName, String password, String userType){
        if(StringUtils.isNotBlank(userId)){
            UserDO userDO = userManager.selectByPrimaryKey(Long.valueOf(userId));
            if(userDO != null){
                if(StringUtils.isNotBlank(userName)){
                    userDO.setUserName(userName);
                }
                if(StringUtils.isNotBlank(nickName)){
                    userDO.setUserNickName(nickName);
                }
                if(StringUtils.isNotBlank(password)){
                    userDO.setPassword(password);
                }
                log.info("update user info success", userId);
            }
        }else {
            log.info("user id is null", userId);
        }
    }
}
