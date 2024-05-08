package com.example.demo.JPA_DB.Student_DB;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class StudentControllerDB {

	/* Devolver objeto inyectando de un servicio (Mejor manera) */
	private final StudentServiceDB studentServiceDB;
	
	/* Para que funcione la inyeccion, añadir a servicio @Service*/
	public StudentControllerDB(StudentServiceDB studentServiceDB) {
		this.studentServiceDB = studentServiceDB;
	}
	
	//get
	@GetMapping
	public List<StudentDB> getStudentDB() {
		return studentServiceDB.getStudentDB();
	}
	
	//create
	@PostMapping
	public void registerNewStudent(
			@RequestBody StudentDB student) {
		studentServiceDB.addNewStudent(student);
	}
	
	//borrar
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(
			@PathVariable("studentId") Long studentId) {
		studentServiceDB.deleteStudent(studentId);
	}
	
	//update
	@PutMapping((path = "{studentId}"))
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		studentServiceDB.updateStudent(studentId, name, email);	
	}
	
	/* Devolver objeto sin servicio ni inyeccion del mismo */
	@GetMapping
	public List<StudentDB> devolver() {
	    return List.of(
	        new StudentDB(
	            "Pepe",
	            "Perez",
	            "email",
	            21
	        )
	    );
	}
	
	
}