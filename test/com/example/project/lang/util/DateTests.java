package com.example.project.lang.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class DateTests {
    /**
     * 包含日期和时间信息
     */
    Date date = new Date();

    /**
     * 只包含日期信息
     */
    LocalDate localDate = LocalDate.now();

    /**
     * 线程安全的不可变类
     */
    LocalDateTime localDateTime = LocalDateTime.now();

    LocalTime localTime = LocalTime.now();

    /**
     * 不是线程安全，日期格式化
     */
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    @DisplayName("日期格式化，转换为字符串")
    void format(){
        Date date = new Date();
        // 对共享变量加同步锁
        synchronized(simpleDateFormat){
            String dateString = simpleDateFormat.format(date);
            System.out.println(dateString);
        }

    }


}
