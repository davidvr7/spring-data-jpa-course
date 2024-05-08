package com.example.demo.JPA_DB;

import org.springframework.data.repository.CrudRepository;

public interface StudentIdCardRepository
        extends CrudRepository<StudentIdCard, Long> {
}
