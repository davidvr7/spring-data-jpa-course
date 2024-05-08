package com.example.demo.JPAwithoutDB.StudentwithoutDB;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;
 
@Service /* para que funcione la inyeccion en controller*/
public class StudentServiceWithoutDB {

	public List<StudentWithoutDB> getStudentWithoutDB() {
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
