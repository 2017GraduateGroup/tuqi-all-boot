package com.tuqi.controller;

import com.tuqi.domain.model.DailyRecordDO;
import com.tuqi.domain.query.DailyRecordQuery;
import com.tuqi.manager.DailyRecordManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.tuqi.util.ConstantUtil.ISEFFECTIVE;

/**
 * Created by Xianrui Ke on 2017/5/13.
 */
@Controller
@RequestMapping("dairecord")
public class DailyRecordController {
    @Autowired
    DailyRecordManager dailyRecordManager;

    /**
     * 添加日志
     *
     * @param userId
     * @param title
     * @param content
     * @param remarks
     * @param model
     * @return
     */
    @RequestMapping("addDailyRecord")
    public String addDailyRecord(@RequestParam String userId, @RequestParam String title,
                                 @RequestParam String content, @RequestParam String remarks, Model model) {
        if (StringUtils.isNotBlank(userId)) {
            DailyRecordDO recordDO = new DailyRecordDO();
            if (StringUtils.isNotBlank(title)) {
                recordDO.setTitle(title);
            }
            if (StringUtils.isNotBlank(content)) {
                recordDO.setContent(content);
            }
            if (StringUtils.isNotBlank(remarks)) {
                recordDO.setRemarks(remarks);
            }
            recordDO.setRecordUserId(Long.valueOf(userId));
            recordDO.setStatus(ISEFFECTIVE);
            dailyRecordManager.insertSelective(recordDO);
            DailyRecordQuery dailyRecordQuery = new DailyRecordQuery();
            dailyRecordQuery.createCriteria().andRecordUserIdEqualTo(Long.valueOf(userId));
            List<DailyRecordDO> dailyRecordDOS = dailyRecordManager.selectByQuery(dailyRecordQuery);
            model.addAllAttributes(dailyRecordDOS);
        } else {
            return "/showDailyRecord";
        }
        return "/dailyRecordList";
    }

    /**
     * 更新日志
     *
     * @param userId
     * @param title
     * @param content
     * @param remarks
     * @return
     */
    @RequestMapping("updateDailyRecord")
    public String updateDailyRecord(@RequestParam String userId, @RequestParam String dailyRecordId, String title, String content, String remarks) {
        if (StringUtils.isNotBlank(dailyRecordId)) {
            DailyRecordDO dailyRecordDO = dailyRecordManager.selectByPrimaryKey(Long.valueOf(dailyRecordId));
            if (null != dailyRecordDO) {
                if (StringUtils.isNotBlank(title)) {
                    dailyRecordDO.setTitle(title);
                }
                if (StringUtils.isNotBlank(content)) {
                    dailyRecordDO.setContent(content);
                }
                if (StringUtils.isNotBlank(remarks)) {
                    dailyRecordDO.setRemarks(remarks);
                }
                dailyRecordManager.updateByPrimaryKeySelective(dailyRecordDO);
            }
        }

        return "/showDailyRecord";
    }

    /**
     * 删除日志
     *
     * @param dailyRecordNum
     * @return
     */
    @RequestMapping("deleteDailyRecord")
    public String deleteDailyRecord(@RequestParam String dailyRecordNum) {
        if (StringUtils.isNotBlank(dailyRecordNum)) {
            DailyRecordQuery dailyRecordQuery = new DailyRecordQuery();
            dailyRecordQuery.createCriteria().andRecordidEqualTo(Long.valueOf(dailyRecordNum));
            dailyRecordManager.deleteByQuery(dailyRecordQuery);
        }
        return "/showDailyRecord";
    }

    /**
     * 查看所有日志
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("queryDailyRecord")
    public List queryDailyRecord(@RequestParam String userId) {
        if (StringUtils.isNotBlank(userId)) {
            DailyRecordQuery dailyRecordQuery = new DailyRecordQuery();
            dailyRecordQuery.createCriteria().andRecordUserIdEqualTo(Long.valueOf(userId));
            List<DailyRecordDO> dailyRecordDOList = dailyRecordManager.selectByQuery(dailyRecordQuery);
            return dailyRecordDOList;
        } else {
            return null;
        }
    }
}
