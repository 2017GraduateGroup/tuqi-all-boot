package com.tuqi.controller;

import com.tuqi.domain.model.BizResult;
import com.tuqi.domain.model.DailyRecordDO;
import com.tuqi.domain.query.DailyRecordQuery;
import com.tuqi.manager.DailyRecordManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.tuqi.util.ConstantUtil.ISEFFECTIVE;

/**
 * Created by Xianrui Ke on 2017/5/13.
 */
@RestController
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
     * @return
     */
    @RequestMapping("addDailyRecord")
    public BizResult addDailyRecord(@RequestParam String userId, @RequestParam String title,
                                    @RequestParam String content, @RequestParam String remarks) {
        BizResult bizResult = new BizResult();
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
            Long result = dailyRecordManager.insertSelective(recordDO);
            if(result > 0){
                bizResult.setCode("1");
                bizResult.setMessage("success");
                return bizResult;
            }
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
    }

    /**
     * 更新日志
     *
     * @param title
     * @param content
     * @param remarks
     * @return
     */
    @RequestMapping("updateDailyRecord")
    public BizResult updateDailyRecord(@RequestParam String dailyRecordId, String title, String content, String remarks) {
        BizResult bizResult = new BizResult();
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
                Integer result = dailyRecordManager.updateByPrimaryKeySelective(dailyRecordDO);
                if(result > 0){
                    bizResult.setCode("1");
                    bizResult.setMessage("success");
                    return bizResult;
                }
            }
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
    }

    /**
     * 删除日志
     *
     * @param dailyRecordNum
     * @return
     */
    @RequestMapping("deleteDailyRecord")
    public BizResult deleteDailyRecord(@RequestParam String dailyRecordNum) {
        BizResult bizResult = new BizResult();
        if (StringUtils.isNotBlank(dailyRecordNum)) {
            DailyRecordQuery dailyRecordQuery = new DailyRecordQuery();
            dailyRecordQuery.createCriteria().andRecordidEqualTo(Long.valueOf(dailyRecordNum));
            Integer result = dailyRecordManager.deleteByQuery(dailyRecordQuery);
            if(result > 0){
                bizResult.setCode("1");
                bizResult.setMessage("success");
                return bizResult;
            }
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
    }

    /**
     * 查看所有日志
     *
     * @param userId
     * @return
     */
    @RequestMapping("queryDailyRecord")
    public List queryDailyRecord(@RequestParam String userId) {
        if (StringUtils.isNotBlank(userId)) {
            DailyRecordQuery dailyRecordQuery = new DailyRecordQuery();
            dailyRecordQuery.createCriteria().andRecordUserIdEqualTo(Long.valueOf(userId));
            List<DailyRecordDO> dailyRecordDOList = dailyRecordManager.selectByQuery(dailyRecordQuery);
            List<DailyRecordDO> dailyRecordDOS = new ArrayList<>();
            for(DailyRecordDO dailyRecordDO : dailyRecordDOList){
                dailyRecordDO.setCreatTime(getFormatTime(dailyRecordDO.getGmtCreate()));
                dailyRecordDOS.add(dailyRecordDO);
            }
            return dailyRecordDOS;
        } else {
            return null;
        }
    }

    @RequestMapping("queryDailyRecordByCondition")
    public BizResult queryDailyRecordByCondition(String title, String contentKey, String remarks,
                                                 String createTime){
        BizResult bizResult = new BizResult();
        DailyRecordQuery dailyRecordQuery = new DailyRecordQuery();
        //全条件
        if(StringUtils.isNotBlank(title) && StringUtils.isNotBlank(contentKey) && StringUtils.isNotBlank(remarks) &&
                StringUtils.isNotBlank(createTime)){
            dailyRecordQuery.createCriteria().andTitleLike(title).andContentLike(contentKey).
                    andRemarksLike(remarks).andCreatTimeEqualTo(createTime);
        }
        //title+content+remarks
        if(StringUtils.isNotBlank(title) && StringUtils.isNotBlank(contentKey) && StringUtils.isNotBlank(remarks) &&
                StringUtils.isBlank(createTime)){
            dailyRecordQuery.createCriteria().andTitleLike(title).andContentLike(contentKey).
                    andRemarksLike(remarks);
        }
        //title+content
        if(StringUtils.isNotBlank(title) && StringUtils.isNotBlank(contentKey) && StringUtils.isBlank(remarks) &&
                StringUtils.isBlank(createTime)){
            dailyRecordQuery.createCriteria().andTitleLike(title).andContentLike(contentKey);
        }
        //title+remarks
        if(StringUtils.isNotBlank(title) && StringUtils.isBlank(contentKey) && StringUtils.isNotBlank(remarks) &&
                StringUtils.isBlank(createTime)){
            dailyRecordQuery.createCriteria().andTitleLike(title).andContentLike(contentKey).
                    andRemarksLike(remarks);
        }
        //title+time
        if(StringUtils.isNotBlank(title) && StringUtils.isBlank(contentKey) && StringUtils.isBlank(remarks) &&
                StringUtils.isNotBlank(createTime)){
            dailyRecordQuery.createCriteria().andTitleLike(title).andCreatTimeEqualTo(createTime);
        }
        //title
        if(StringUtils.isNotBlank(title) && StringUtils.isBlank(contentKey) && StringUtils.isBlank(remarks) &&
                StringUtils.isBlank(createTime)){
            dailyRecordQuery.createCriteria().andTitleLike(title);
        }
        //content
        if(StringUtils.isBlank(title) && StringUtils.isNotBlank(contentKey) && StringUtils.isBlank(remarks) &&
                StringUtils.isBlank(createTime)){
            dailyRecordQuery.createCriteria().andContentLike(contentKey);
        }
        //remarks
        if(StringUtils.isBlank(title) && StringUtils.isBlank(contentKey) && StringUtils.isNotBlank(remarks) &&
                StringUtils.isBlank(createTime)){
            dailyRecordQuery.createCriteria().andRemarksLike(remarks);
        }
        //time
        if(StringUtils.isBlank(title) && StringUtils.isBlank(contentKey) && StringUtils.isBlank(remarks) &&
                StringUtils.isNotBlank(createTime)){
            dailyRecordQuery.createCriteria().andCreatTimeEqualTo(createTime);
        }
        List<DailyRecordDO> dailyRecordDOList = dailyRecordManager.selectByQuery(dailyRecordQuery);
        bizResult.setCode("1");
        bizResult.setMessage("success");
        bizResult.setDataList(dailyRecordDOList);
        return bizResult;
    }

    public Date getDate(String strDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 格式化时间
     * @return
     */
    private static String getFormatTime(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = simpleDateFormat.format(date);
        return time;
    }
}
