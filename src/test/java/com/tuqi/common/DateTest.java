package com.tuqi.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by FAMILY on 2017/6/9.
 */
public class DateTest {

    public static void main(String[] args){
        Date nowtime = new Date();
        Long longtime = 5*60*1000L;

        Date fiveAfter = new Date(nowtime.getTime() + longtime);
        Date fiveBefor = new Date(nowtime.getTime() - longtime);
        System.out.println(fiveAfter);
        System.out.println(fiveBefor);
    }
}
