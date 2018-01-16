package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.timesheet.TimeSpreadSheetApplication;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)



@SpringBootTest(classes = TimeSpreadSheetApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TimeSpreadSheetApplicationTests {

	@Test
	public void contextLoads() {
	}

}
