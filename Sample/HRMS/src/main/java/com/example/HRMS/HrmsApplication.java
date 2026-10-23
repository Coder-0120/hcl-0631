package com.example.HRMS;

import com.example.HRMS.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
//		EmployeeController emp=new EmployeeController();
//		emp.Welcome();
//		emp.Sum(20,30);
	}

}
