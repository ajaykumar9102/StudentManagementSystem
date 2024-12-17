package com.studentmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmgmt.model.Student;
import com.studentmgmt.repository.Studentrepo;
@Service
public class Studentservice {
	//listAllStudent->Read all students
	//saveStudent->write student in db
	//getStudentById(id)->Student
	//updateStudent(Student student)->update
	//deleteStudentById(id)->delete student of that id
	@Autowired
	Studentrepo studentrepo;
 public List<Student> listAllStudent(){
	 return studentrepo.findAll();
 }
 public Student saveStudent(Student student) {
	 return studentrepo.save(student);
 }
 public Student getStudentById(Long id) {
	 return studentrepo.findById(id).get();
 }
 public void deleteStudentById(long id) {
	  studentrepo.deleteById(id);
 }
}
