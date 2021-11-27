package com.amirdehi.quvo.util;

import java.util.Calendar;
import java.util.Date;

public class Util {

    public static Date getPlannedDate(int planNumber){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        switch (planNumber){// 1day, 2day, 3day, 1week, 2week, 1month
            case 1:
                c.add(Calendar.DATE, 1);
                return c.getTime();
            case 2:
                c.add(Calendar.DATE, 2);
                return c.getTime();
            case 3:
                c.add(Calendar.DATE, 3);
                return c.getTime();
            case 4:
                c.add(Calendar.DATE, 7);
                return c.getTime();
            case 5:
                c.add(Calendar.DATE, 14);
                return c.getTime();
            case 6:
                c.add(Calendar.DATE, 30);
                return c.getTime();
        }
        return null;
    }
}
