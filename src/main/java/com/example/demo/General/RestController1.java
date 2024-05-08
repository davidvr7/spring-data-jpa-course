package com.example.demo.General;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JPAwithoutDB.StudentwithoutDB.StudentWithoutDB;

@RestController
public class RestController1 {

	/* Devolver cadena */
	@GetMapping()
	public String hello() {
		return "Hello World";
	}

	/* Devolver array */
	@GetMapping()
	public List<String> hello2() {
		return List.of("Hello World");
	}
 
	/* Devolver objeto */
	/* Vease StudentRestController */
	public List<StudentWithoutDB> hello3() {
	    return List.of(
	        new StudentWithoutDB(
	            "Pepe",
	            "Perez",
	            LocalDate.of(2000, Month.JANUARY, 5),
	            21
	        )
	    );
	}
	
}
