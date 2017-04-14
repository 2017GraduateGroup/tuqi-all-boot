package com.tuqi.controller;

import com.tuqi.domain.model.UserPositionDO;
import com.tuqi.domain.query.UserPositionQuery;
import com.tuqi.manager.UserPositionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by tuqi on 17/3/20.
 */
@Controller
public class HelloController {

    @Autowired
    UserPositionManager userPositionManager;

    @RequestMapping("index")
    public String sayHelloTools(Model model){
        UserPositionQuery userPositionQuery = new UserPositionQuery();
        userPositionQuery.createCriteria().andPositionIdIsNotNull();
        List<UserPositionDO> userPositionDOList =  userPositionManager.selectByQuery(userPositionQuery);
        model.addAttribute("userPositionDOList", userPositionDOList);
        return "/loginAndRegister";
    }
}
