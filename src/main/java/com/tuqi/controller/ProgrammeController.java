package com.tuqi.controller;

import com.tuqi.domain.model.ProgrammeDO;
import com.tuqi.domain.model.UserDO;
import com.tuqi.domain.query.ProgrammeQuery;
import com.tuqi.manager.ProgrammeManager;
import com.tuqi.manager.UserManager;
import com.tuqi.util.ProgrammeType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.tuqi.util.ConstantUtil.ISEFFECTIVE;

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
    public void addProgramme(@RequestParam String userId, @RequestParam String content, @RequestParam String programmeTime,
                               @RequestParam String programmeType, Model model){
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
        if(StringUtils.isNotBlank(programmeTime)){
            programmeDO.setProgrammeTime(programmeTime);
        }
        if(StringUtils.isNotBlank(programmeType)){
            for (ProgrammeType programmeTypeItem : ProgrammeType.values()) {
                if(StringUtils.equals(programmeType, programmeTypeItem.getDesc())){
                    programmeDO.setProgramTypeId(programmeTypeItem.getCode());
                }
            }
        }
        programmeDO.setStatus(ISEFFECTIVE);
        model.addAttribute("user", userDO);
        programmeManager.insertSelective(programmeDO);
    }

    /**
     * 修改日程
     * @param programmeId
     * @param content
     * @return
     */
    @RequestMapping("updateProgramme")
    public void updateProgramme(@RequestParam String programmeId, @RequestParam String content){
        ProgrammeDO programmeDO = new ProgrammeDO();
        if(StringUtils.isNotBlank(programmeId)){
            programmeDO = programmeManager.selectByPrimaryKey(Long.valueOf(programmeId));
        }
        if(null != programmeDO && StringUtils.isNotBlank(content)){
            programmeDO.setContent(content);
        }
        programmeManager.updateByPrimaryKeySelective(programmeDO);
    }

    /**
     * 删除日程
     * @param programmeId
     * @return
     */
    @RequestMapping("deleteProgramme")
    public void deleteProgramme(@RequestParam String programmeId){
        if(StringUtils.isNotBlank(programmeId)){
            programmeManager.deleteByPrimaryKey(programmeManager.selectByPrimaryKey(Long.valueOf(programmeId)));
        }
    }

    /**
     * 查询当前用户的所有日程安排
     * @param userId
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("queryProgramme")
    public List queryProgramme(@RequestParam String userId, String programmeType, String key, Model model){
        ProgrammeQuery programmeQuery = new ProgrammeQuery();
        if(StringUtils.isNotBlank(userId)){
            programmeQuery.createCriteria().andProgramUserIdEqualTo(Long.valueOf(userId));
            //如果传入的参数存在日程类型，加入筛选条件
            if(StringUtils.isNotBlank(programmeType)){
                programmeQuery.createCriteria().andProgramTypeIdEqualTo(Integer.valueOf(programmeType));
            }
            //如果传入的参数存在关键字，加入筛选条件
            if(StringUtils.isNotBlank(key)){
                programmeQuery.createCriteria().andContentLike(key);
            }
        }
        List<ProgrammeDO> programmeList = programmeManager.selectByQuery(programmeQuery);
        model.addAllAttributes(programmeList);
        return programmeList;
    }
//    /**
//     * 获取当前时间
//     * @return
//     */
//    private String getNowTime(){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        return simpleDateFormat.format(new Date());
//    }
}
