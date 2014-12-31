/*
 * Copyright © 2014-2015 Paul Waslowski <freack1208@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the LICENSE file for more details.
 */

package me.freack100.timesync;

import java.util.*;

public class TimeConverter {

    Calendar calendar = GregorianCalendar.getInstance();
    Date date;
    int offset = 6;

    public TimeConverter() {
        this.offset = 6;
    }

    public TimeConverter(int input) {
        this.offset = input;
    }

    public String code2Time(long now) {
        int hours = (int) ((now / 1000L + this.offset) % 24L);
        int minutes = (int) (60L * (now % 1000L) / 1000L);
        String sminutes = String.valueOf(minutes);
        String shours = String.valueOf(hours);
        if (hours <= 9) {
            shours = "0" + hours;
        }
        if (minutes <= 9) {
            sminutes = "0" + minutes;
        }
        return shours + ":" + sminutes;
    }

    public long time2Code(String time) {
        long now = -1L;
        if (time.isEmpty()) {
            return -1L;
        }
        int dp = time.indexOf(":");
        if (dp <= 0) {
            return -10 + dp;
        }
        int hours = 0;
        int minutes = 0;
        String[] Timeray = time.split(":");
        try {
            hours = Integer.parseInt(Timeray[0]);
        } catch (Exception e) {
            return -2L;
        }
        try {
            minutes = Integer.parseInt(Timeray[1]);
        } catch (Exception e) {
            return -3L;
        }
        now = (hours - this.offset) * 1000;
        if (now < 0L) {
            now += 24000L;
        }
        double tminutes = minutes * 16.666699999999999D;
        now += (int) tminutes;
        return now;
    }

    public String time() {
        this.date = new Date();
        this.calendar.setTime(this.date);

        int intMin = this.calendar.get(12);
        String minute;
        if (intMin < 10) {
            minute = "0" + intMin;
        } else {
            minute = "" + intMin;
        }
        return this.calendar.get(11) + ":" + minute;
    }

}
