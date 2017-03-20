package com.tuqi.controller;

import com.tuqi.domain.model.UserTabDO;
import com.tuqi.domain.query.UserTabQuery;
import com.tuqi.manager.UserTabManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tuqi on 17/3/20.
 */
@Controller
@RequestMapping("hello")
public class HelloController {
    @Autowired
    UserTabManager userTabManager;

    @RequestMapping("sayHelloTools")
    public String sayHelloTools(Model model){
        UserTabQuery userTabQuery = new UserTabQuery();
        userTabQuery.createCriteria().andUsernameIsNotNull();
        List<UserTabDO> userTabDOList = userTabManager.selectByQuery(userTabQuery);
        model.addAttribute("userTabDOList", userTabDOList);
        model.addAttribute("content", "CONTENT");
        return "/hello";
    }
}
