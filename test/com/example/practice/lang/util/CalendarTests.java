package com.example.practice.lang.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

class CalendarTests {

    @Test
    @DisplayName("日历")
    void test(){
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(month);
    }

}
