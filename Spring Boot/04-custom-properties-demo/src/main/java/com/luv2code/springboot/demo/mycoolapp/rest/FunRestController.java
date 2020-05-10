package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String helloWorld() {
		return "Hellooo World! The current date/time is: " + LocalDateTime.now();
	}
	
	@GetMapping("/names")
	public String getNames() {
		return "Coach: " + this.coachName + "\n Team: " + this.teamName;
	}
}
