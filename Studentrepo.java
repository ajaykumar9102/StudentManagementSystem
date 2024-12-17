package com.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmgmt.model.Student;

@Repository
public interface Studentrepo extends JpaRepository <Student,Long> {
	

}
