package com.example.sms.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

@Controller
public class StudentController {
	

	private StudentService studentService;
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		 List<Student> list= studentService.getAllStudents();
		 System.out.println(list);
		model.addAttribute("students",list);
		return "students";
		
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	@PostMapping("/studentsave")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		System.out.println(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student",studentService.getStudentById(id));

		return "edit_student";
		
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model maodel)
	{
		Student existingStudent=studentService.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setFirstname(student.getFirstname());
		
		existingStudent.setLastname(student.getLastname());
		
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		
		
		
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		
		return "redirect:/students";
		
	}
	

}
