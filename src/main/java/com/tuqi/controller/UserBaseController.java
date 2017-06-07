package com.tuqi.controller;

import com.tuqi.domain.model.BizResult;
import com.tuqi.domain.model.UserDO;
import com.tuqi.domain.query.UserQuery;
import com.tuqi.manager.UserManager;
import com.tuqi.util.MyMD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Xianrui Ke on 2017/4/12.
 */

@RestController
@RequestMapping("user")
@Slf4j
public class UserBaseController {
    @Autowired
    UserManager userManager;

    /**
     * 用户注册
     * @param rUsername
     * @param rPasswd
     * @param rNickname
     * @param rPosition
     * @return
     */
    @RequestMapping("userRegister")
    public BizResult userRegister(@RequestParam String rUsername,@RequestParam String rPasswd,@RequestParam(required = false) String rNickname,
                               @RequestParam(required = false) String rPosition){
        UserDO userDO = new UserDO();
        BizResult bizResult = new BizResult();
        if(StringUtils.isNotBlank(rUsername)){
            UserQuery userQuery = new UserQuery();
            userQuery.createCriteria().andUserNickNameEqualTo(rNickname);
            List<UserDO> userDOList = userManager.selectByQuery(userQuery);
            if(userDOList.size() > 0){
                log.info("user is exist, please change");
                bizResult.setCode("0");
                bizResult.setMessage("fail");
                return bizResult;
            }else {
                if(StringUtils.isNotBlank(rUsername)){
                    userDO.setUserName(rUsername);
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
                userDO.setUserType(0);
                Long result = userManager.insertSelective(userDO);
                if(result > 0){
                    log.info("insert new user success", userDO.getUserName());
                    bizResult.setCode("1");
                    bizResult.setMessage("success");
                    return bizResult;
                }else{
                    log.info("insert new user fail");
                    bizResult.setCode("0");
                    bizResult.setMessage("fail");
                    return bizResult;
                }
            }
        }
        return bizResult;
    }

    /**
     * 用户登录
     * @param usernameInput
     * @param passwdInput
     * @param request
     * @return
     */
    @RequestMapping("userLogin")
    public BizResult userLogin(@RequestParam String usernameInput, @RequestParam String passwdInput, HttpServletRequest request){
        BizResult bizResult = new BizResult();
        if(StringUtils.isNotBlank(usernameInput)){
            UserQuery userQuery = new UserQuery();
            userQuery.createCriteria().andUserNickNameEqualTo(usernameInput).andPasswordEqualTo(MyMD5Util.code(passwdInput));
            List<UserDO> userDOList = userManager.selectByQuery(userQuery);
            if(userDOList.size() > 0){
                request.getSession().setAttribute("currentUserId", userDOList.get(0).getUserId());
                bizResult.setCode("1");
                bizResult.setData(userDOList.get(0).getUserId().toString());
                bizResult.setMessage("login success");
                return bizResult;
            }else{
                bizResult.setCode("0");
                bizResult.setMessage("login fail");
                return bizResult;
            }
        }
        return bizResult;
    }

    /**
     * 获取所有的用户信息
     * @return
     */
    @RequestMapping("getAllUserInfo")
    public List getAllUserInfo(){
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andUserIdIsNotNull();
        List<UserDO> userDOList = userManager.selectByQuery(userQuery);
        return userDOList;
    }

    /**
     * 修改用户信息
     * @param userId
     * @param userName
     * @param nickName
     * @param password
     * @param userType
     * @return
     */
    @RequestMapping("updateUserInfo")
    public BizResult updateUserInfo(@RequestParam String userId,String userName, String nickName, String password, String userType){
        BizResult bizResult = new BizResult();
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
                bizResult.setCode("1");
                bizResult.setMessage("success");
                log.info("update user info success", userId);
                return bizResult;
            }
        }else {
            bizResult.setCode("0");
            bizResult.setMessage("fail");
            log.info("user id is null", userId);
            return bizResult;
        }
        return bizResult;
    }

    @RequestMapping("queryAllUser")
    public BizResult queryAllUser(){
        BizResult bizResult = new BizResult();
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andUserIdIsNotNull();
        List<UserDO> userDOList = userManager.selectByQuery(userQuery);
        bizResult.setCode("1");
        bizResult.setMessage("success");
        bizResult.setDataList(userDOList);
        return bizResult;
    }
}
