package com.example.demo.JPAwithoutDB.StudentwithoutDB;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControllerWithoutDB {

	/* Devolver objeto inyectando de un servicio (Mejor manera) */
	private final StudentServiceWithoutDB studentServiceWithoutDB;
	
	/* Para que funcione la inyeccion, añadir a servicio @Service*/
	public StudentControllerWithoutDB(StudentServiceWithoutDB studentServiceWithoutDB) {
		this.studentServiceWithoutDB = studentServiceWithoutDB;
	}
	
	@GetMapping
	public List<StudentWithoutDB> getStudentWithoutDB() {
		return studentServiceWithoutDB.getStudentWithoutDB();
	}
	
	/* Devolver objeto sin servicio ni inyeccion del mismo */
	@GetMapping
	public List<StudentWithoutDB> devolver() {
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
