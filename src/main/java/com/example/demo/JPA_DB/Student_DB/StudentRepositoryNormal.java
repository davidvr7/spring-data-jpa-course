package com.example.demo.JPA_DB.Student_DB;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*Lo de repository para que funcione y jpa para que haga cosas sobre esa entidad*/
@Repository
public interface StudentRepositoryNormal
		extends JpaRepository<StudentDB, Long>{
	
		@Query("SELECT s FROM Student s WHERE s.email = ?1")
		Optional<StudentDB> findStudentByEmail(String email);
}
