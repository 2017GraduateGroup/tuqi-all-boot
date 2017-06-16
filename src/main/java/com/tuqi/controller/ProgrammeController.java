package com.tuqi.controller;

import com.tuqi.domain.model.BizResult;
import com.tuqi.domain.model.ProgrammeDO;
import com.tuqi.domain.model.UserDO;
import com.tuqi.domain.query.ProgrammeQuery;
import com.tuqi.manager.ProgrammeManager;
import com.tuqi.manager.UserManager;
import com.tuqi.util.ProgrammeType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.tuqi.util.ConstantUtil.ISEFFECTIVE;

/**
 * Created by Xianrui Ke on 2017/4/26.
 */
@RestController
@RequestMapping("programme")
public class ProgrammeController {
    @Autowired
    UserManager userManager;
    @Autowired
    ProgrammeManager programmeManager;

    /**
     * 添加日程
     *
     * @param userId
     * @param content
     * @return
     */
    @RequestMapping("addProgramme")
    public BizResult addProgramme(@RequestParam String userId, @RequestParam String content, @RequestParam String programmeTime,
                                  @RequestParam String programmeType) {
        BizResult bizResult = new BizResult();
        UserDO userDO = new UserDO();
        ProgrammeDO programmeDO = new ProgrammeDO();
        if (StringUtils.isNotBlank(userId)) {
            userDO = userManager.selectByPrimaryKey(Long.valueOf(userId));
        }
        if (null != userDO) {
            programmeDO.setProgramUserId(userDO.getUserId());
        }
        if (StringUtils.isNotBlank(content)) {
            programmeDO.setContent(content);
        }
        if (StringUtils.isNotBlank(programmeTime)) {
            programmeDO.setProgrammeTime(programmeTime);
        }
        if (StringUtils.isNotBlank(programmeType)) {
            programmeDO.setProgramTypeId(Integer.valueOf(programmeType));
        }
        programmeDO.setStatus(ISEFFECTIVE);
        Long result = programmeManager.insertSelective(programmeDO);
        if (result > 0) {
            bizResult.setCode("1");
            bizResult.setMessage("success");
            return bizResult;
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
    }

    /**
     * 修改日程
     *
     * @param programmeId
     * @param content
     * @return
     */
    @RequestMapping("updateProgramme")
    public BizResult updateProgramme(@RequestParam String programmeId, @RequestParam String content) {
        BizResult bizResult = new BizResult();
        ProgrammeDO programmeDO = new ProgrammeDO();
        if (StringUtils.isNotBlank(programmeId)) {
            programmeDO = programmeManager.selectByPrimaryKey(Long.valueOf(programmeId));
        }
        if (null != programmeDO && StringUtils.isNotBlank(content)) {
            programmeDO.setContent(content);
        }
        Integer result = programmeManager.updateByPrimaryKeySelective(programmeDO);
        if (result > 0) {
            bizResult.setCode("1");
            bizResult.setMessage("success");
            return bizResult;
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
    }

    /**
     * 删除日程
     *
     * @param programmeId
     * @return
     */
    @RequestMapping("deleteProgramme")
    public void deleteProgramme(@RequestParam String programmeId) {
        if (StringUtils.isNotBlank(programmeId)) {
            programmeManager.deleteByPrimaryKey(programmeManager.selectByPrimaryKey(Long.valueOf(programmeId)));
        }
    }

    /**
     * 查询当前用户的所有日程安排
     *
     * @param userId
     * @return
     */
    @RequestMapping("queryProgramme")
    public List queryProgramme(@RequestParam String userId, String programmeType, String key) {
        ProgrammeQuery programmeQuery = new ProgrammeQuery();
        if (StringUtils.isNotBlank(userId)) {
            programmeQuery.createCriteria().andProgramUserIdEqualTo(Long.valueOf(userId)).
                    andStatusEqualTo("1");
            //如果传入的参数存在日程类型，加入筛选条件
            if (StringUtils.isNotBlank(programmeType)) {
                programmeQuery.createCriteria().andProgramTypeIdEqualTo(Integer.valueOf(programmeType));
            }
            //如果传入的参数存在关键字，加入筛选条件
            if (StringUtils.isNotBlank(key)) {
                programmeQuery.createCriteria().andContentLike(key);
            }
        }
        List<ProgrammeDO> programmeList = programmeManager.selectByQuery(programmeQuery);
        return programmeList;
    }

    /**
     * 多条件查找日程信息
     * @param key
     * @param programmeTime
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping("queryProgrammeByCondition")
    public BizResult queryProgrammeByCondition(String key, String programmeTime, String startTime,
                                    String endTime, String programmeType){
        BizResult bizResult = new BizResult();
        ProgrammeQuery programmeQuery = new ProgrammeQuery();
        //全部搜索条件
        if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(programmeTime) && StringUtils.isNotBlank(startTime)
                && StringUtils.isNotBlank(endTime) && StringUtils.isNotBlank(programmeType)){
            programmeQuery.createCriteria().andContentLike(key).andProgrammeTimeEqualTo(programmeTime)
                    .andGmtCreateBetween(getDate(startTime), getDate(endTime)).andProgramTypeIdEqualTo(Integer.valueOf(programmeType));
        }
        //无事件类型
        if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(programmeTime) && StringUtils.isNotBlank(startTime)
                && StringUtils.isNotBlank(endTime) && StringUtils.isBlank(programmeType)){
            programmeQuery.createCriteria().andContentLike(key).andProgrammeTimeEqualTo(programmeTime)
                    .andGmtCreateBetween(getDate(startTime), getDate(endTime));
        }
        //关键字+事件发生时间
        if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(programmeTime) && (StringUtils.isBlank(startTime) ||
                StringUtils.isBlank(endTime)) && StringUtils.isBlank(programmeType)){
            programmeQuery.createCriteria().andContentLike(key).andProgrammeTimeEqualTo(programmeTime);
        }
        //关键字+时间段搜索
        if(StringUtils.isNotBlank(key) && StringUtils.isBlank(programmeTime) && (StringUtils.isNotBlank(startTime) &&
                StringUtils.isNotBlank(endTime)) && StringUtils.isBlank(programmeType)){
            programmeQuery.createCriteria().andContentLike(key).andGmtCreateBetween(getDate(startTime), getDate(endTime));
        }
        //时间段+日程类型
        if(StringUtils.isBlank(key) && StringUtils.isBlank(programmeTime) && (StringUtils.isNotBlank(startTime) &&
                StringUtils.isNotBlank(endTime)) && StringUtils.isBlank(programmeType)){
            programmeQuery.createCriteria().andGmtCreateBetween(getDate(startTime), getDate(endTime))
                    .andProgramTypeIdEqualTo(Integer.valueOf(programmeType));
        }
        //事件发生时间+类型
        if(StringUtils.isBlank(key) && StringUtils.isNotBlank(programmeTime) && (StringUtils.isBlank(startTime) ||
                StringUtils.isBlank(endTime)) && StringUtils.isNotBlank(programmeType)){
            programmeQuery.createCriteria().andProgrammeTimeEqualTo(programmeTime).andProgramTypeIdEqualTo(Integer.valueOf(programmeType));
        }
        //关键字+类型
        if(StringUtils.isNotBlank(key) && StringUtils.isBlank(programmeTime) && (StringUtils.isBlank(startTime) ||
                StringUtils.isBlank(endTime)) && StringUtils.isNotBlank(programmeType)){
            programmeQuery.createCriteria().andContentLike(key).andProgramTypeIdEqualTo(Integer.valueOf(programmeType));
        }
        //日程时间搜索
        if(StringUtils.isBlank(key) && StringUtils.isNotBlank(programmeTime) && (StringUtils.isBlank(startTime) ||
                StringUtils.isBlank(endTime)) && StringUtils.isBlank(programmeType)){
            programmeQuery.createCriteria().andProgrammeTimeEqualTo(programmeTime);
        }
        //时间段搜索
        if(StringUtils.isBlank(key) && StringUtils.isBlank(programmeTime) && (StringUtils.isNotBlank(startTime) &&
                StringUtils.isNotBlank(endTime)) && StringUtils.isBlank(programmeType)){
            programmeQuery.createCriteria().andGmtCreateBetween(getDate(startTime), getDate(endTime));
        }
        //事件类型搜索
        if(StringUtils.isBlank(key) && StringUtils.isBlank(programmeTime) && (StringUtils.isBlank(startTime) ||
                StringUtils.isBlank(endTime)) && StringUtils.isNotBlank(programmeType)){
            programmeQuery.createCriteria().andProgramTypeIdEqualTo(Integer.valueOf(programmeType));
        }
        List<ProgrammeDO> programmeDOList = programmeManager.selectByQuery(programmeQuery);
        if(programmeDOList.size() > 0){
            bizResult.setCode("1");
            bizResult.setMessage("success");
            bizResult.setDataList(programmeDOList);
            return bizResult;
        }
        bizResult.setCode("0");
        bizResult.setMessage("no data");
        return bizResult;
    }

    /**
     * 获取需要提醒日程列表
     * @return
     */
    @RequestMapping("getNoticeProgramme")
    public BizResult getNoticeProgramme(){
        BizResult bizResult = new BizResult();
        Date nowTime = new Date();
        Long longTime = 5*60*1000L;
        Date closeTime = new Date(nowTime.getTime() + longTime);
        ProgrammeQuery programmeQuery = new ProgrammeQuery();
        programmeQuery.createCriteria().andGmtCreateEqualTo(closeTime);
        List<ProgrammeDO> programmeDOList = programmeManager.selectByQuery(programmeQuery);
        if(programmeDOList.size() > 0){
            bizResult.setCode("1");
            bizResult.setMessage("have data");
            bizResult.setDataList(programmeDOList);
            return bizResult;
        }else if(programmeDOList.size() == 0){
            bizResult.setCode("2");
            bizResult.setMessage("no data");
            bizResult.setDataList(programmeDOList);
            return bizResult;
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
    }

    //将字符串转换成Date类型
    public Date getDate(String strDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
