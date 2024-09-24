package com.diego699.attendance_sheet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AttendanceSheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceSheetApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(String[] args){
		return runner ->{

		};
	}

}
