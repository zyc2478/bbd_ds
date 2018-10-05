package com.autobid.util;

import org.apache.log4j.Logger;
import java.text.ParseException;
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




    public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

    public static Date calcBeginDate(Date date1, int diffDays){

        long date2_time = date1.getTime() - (long)diffDays * 1000 * 3600 * 24;
        Date date2 = new Date(date2_time);
        return date2;
    }

    //@Test
    public void testDateUtil() throws ParseException {
        DateUtil du = new DateUtil();
        Date nowDate = new Date();
        String fromDate = du.dateToStrYMD(nowDate);
        String endDate = du.dateToStrYMD(du.dateAddDays(nowDate,-15));
        System.out.println(fromDate);
        System.out.println(endDate);
        String dateStrFrom = "2018-01-30";
        String dateStrEnd = "2018-07-29";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom = simpleDateFormat.parse(dateStrFrom);
        Date dateEnd = simpleDateFormat.parse(dateStrEnd);

        System.out.println(differentDaysByMillisecond(dateFrom,dateEnd));

        System.out.println(simpleDateFormat.format(calcBeginDate(new Date(),180)));

        System.out.println(simpleDateFormat.format(calcBeginDate(new Date(),-1)));
    }

}
