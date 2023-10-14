package com.example.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;



@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		
		/*
		
		Student student=new Student(1,"rahul","saw","rahulsaw@gamil.com");
		studentRepository.save(student);
		
		Student student1=new Student(2,"sarwan","saw","sarwansaw@gamil.com");
		studentRepository.save(student1);
		
		*/
		
		
		
		
	}

}
