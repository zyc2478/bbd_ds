package com.autobid.util;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static Logger logger = Logger.getLogger(DateUtil.class);

    public String dateToStrYMD(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = "";
        dateStr = sdf.format(date);
        return dateStr;
    }

    public Date dateAddDays(Date date, int daysNum){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, daysNum);
        Date calcDate = calendar.getTime();
        return calcDate;
    }

    @Test
    public void testDateUtil(){
        DateUtil du = new DateUtil();
        Date nowDate = new Date();
        String fromDate = du.dateToStrYMD(nowDate);
        String endDate = du.dateToStrYMD(du.dateAddDays(nowDate,-15));
        System.out.println(fromDate);
        System.out.println(endDate);
    }

}
