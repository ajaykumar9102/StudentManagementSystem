package com.studentmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmgmt.model.Student;
import com.studentmgmt.service.Studentservice;

@RestController
public class StudentController {
	@Autowired
	Studentservice studentservice;
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("studentsList", studentservice.listAllStudent());
		return "students";
		
	}@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student s=new Student();
		model.addAttribute("studentObject", s);
		return "create_student";
		
	}@PostMapping("/students")
	public String saveStudent(@ModelAttribute("studentObject") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/id")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("studentObject",studentservice.getStudentById(id));
		return "edit_student";
	}
	@PutMapping("/students/id")
 public String updateStudent(@PathVariable Long id,@ModelAttribute("studentObject") Student student) {
	 Student existing =studentservice.getStudentById(id);
	 existing.setFirstName(student.getFirstName());
	 existing.setLastname(student.getLastname());
	 existing.setEmail(student.getEmail());
	 studentservice.saveStudent(student);
	 return "redirect:/students";
	
	 
 }
	@DeleteMapping("/students/id");
	public String deleteStudentById(@PathVariable Long id) {
	studentservice.deleteStudentById(id);
	return "redirect:/students";}
}
