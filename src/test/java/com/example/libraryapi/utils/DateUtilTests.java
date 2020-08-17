package com.example.libraryapi.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class DateUtilTests {

    @Test
    public void TestConvertStringToDate() {
        String str = "08/16/2020";
        Date date = DateUtil.convertStringToDate(str);
        assertEquals("8/16/20", DateUtil.convertDateToString(date));
    }

}
