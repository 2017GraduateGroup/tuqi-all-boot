package com.tuqi.util;

/**
 * Created by Xianrui Ke on 2017/5/17.
 */
public enum ProgrammeType {
    COMMEN(1, "普通"),
    TRIP(2, "出行"),
    METTING(3, "会议"),
    APPOINTMENT(4, "约会"),
    MEMORIALDAY(5, "纪念日"),
    OTHER(6, "其他");

    private Integer code;
    private String desc;

    ProgrammeType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
