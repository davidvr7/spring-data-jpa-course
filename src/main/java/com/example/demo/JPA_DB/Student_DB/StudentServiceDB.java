package com.example.demo.JPA_DB.Student_DB; 

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPAwithoutDB.StudentwithoutDB.StudentWithoutDB;
 
@Service /* para que funcione la inyeccion en controller*/
public class StudentServiceDB {

	private final StudentRepositoryNormal studentRepositoryNormal;
	
	@Autowired
	public StudentServiceDB( StudentRepositoryNormal studentRepositoryNormal) {
		this.studentRepositoryNormal = studentRepositoryNormal;
	}
	
	public List<StudentDB> getStudentDB() {
		return studentRepositoryNormal.findAll();
	}
	
	public void addNewStudent(StudentDB student) {
		Optional<StudentDB> studentOptional = studentRepositoryNormal
											.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		studentRepositoryNormal.save(student);
	}
	
	public void deleteStudent(Long studentId) {
		/* en otros casos mejor algo que no sea id pero sea unico? */
		boolean exists = studentRepositoryNormal.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException("student with id " + studentId + " does not exists");
		}
		
		studentRepositoryNormal.deleteById(studentId);
	}
	
	/* Con esta no hace falta query,  si ocurre un error durante una transacción, todos los cambios se revertirán, puedes hacer la combinacion de esas 3 como quieras, segun lo que añadas */
	@Transactional
	public void updateStudent(Long studentId,
							  String name,
							  String email) {
		StudentDB student = studentRepositoryNormal.findById(studentId)
				.orElseThrow(() -> IllegalStateException("student with id " + studentId + " does not exists"));
		
		if(name != null &&
				name.length() > 0 &&
				!Objects.equals(student.getFirstName(), name)) {
			student.setFirstName(name);
		}
		if(email != null &&
				email.length() > 0 &&
				!Objects.equals(student.getEmail(), email)) {
			Optional<StudentDB> studentOptional = studentRepositoryNormal
					.findStudentByEmail(email);
			if(studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
	}
	
}
