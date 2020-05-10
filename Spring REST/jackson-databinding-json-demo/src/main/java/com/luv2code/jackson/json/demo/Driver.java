package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println("First name: " + student.getFirstName());
			System.out.println("Last name: " + student.getLastName());
			System.out.println("Address: " + student.getAddress());
			System.out.println("Languages: " + student.getLanguages());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
