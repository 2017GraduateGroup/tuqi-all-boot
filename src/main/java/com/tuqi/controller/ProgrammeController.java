package com.tuqi.controller;

import com.tuqi.domain.model.ProgrammeDO;
import com.tuqi.domain.model.UserDO;
import com.tuqi.manager.ProgrammeManager;
import com.tuqi.manager.UserManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Xianrui Ke on 2017/4/26.
 */
@Controller
@RequestMapping("programme")
public class ProgrammeController {
    @Autowired
    UserManager userManager;
    @Autowired
    ProgrammeManager programmeManager;

    /**
     * 添加日程
     * @param userId
     * @param content
     * @param model
     * @return
     */
    @RequestMapping("addProgramme")
    public String addProgramme(@RequestParam String userId, @RequestParam String content, Model model){
        UserDO userDO = new UserDO();
        ProgrammeDO programmeDO = new ProgrammeDO();
        if(StringUtils.isNotBlank(userId)){
            userDO = userManager.selectByPrimaryKey(Long.valueOf(userId));
        }
        if(null != userDO){
            programmeDO.setProgramUserId(userDO.getUserId());
        }
        if(StringUtils.isNotBlank(content)){
            programmeDO.setContent(content);
        }
        programmeDO.setProgrammeTime(getNowTime());
        model.addAttribute("user", userDO);
        programmeManager.insertSelective(programmeDO);
        return "默认首页";
    }

    /**
     * 修改日程
     * @param programmeId
     * @param content
     * @param model
     * @return
     */
    @RequestMapping("updateProgramme")
    public String updateProgramme(@RequestParam String programmeId, @RequestParam String content, Model model){
        ProgrammeDO programmeDO = new ProgrammeDO();
        if(StringUtils.isNotBlank(programmeId)){
            programmeDO = programmeManager.selectByPrimaryKey(Long.valueOf(programmeId));
        }
        if(null != programmeDO && StringUtils.isNotBlank(content)){
            programmeDO.setContent(content);
        }
        programmeManager.updateByPrimaryKeySelective(programmeDO);
        return "";
    }

    /**
     * 删除日程
     * @param programmeId
     * @param model
     * @return
     */
    @RequestMapping("deleteProgramme")
    public String deleteProgramme(@RequestParam String programmeId, Model model){
        if(StringUtils.isNotBlank(programmeId)){
            programmeManager.deleteByPrimaryKey(programmeManager.selectByPrimaryKey(Long.valueOf(programmeId)));
        }
        return "";
    }

    public String queryProgramme(){
        return "";
    }

    /**
     * 获取当前时间
     * @return
     */
    private String getNowTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }
}
