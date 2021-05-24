package de.tekup.factories;

import de.tekup.soap.models.whitetest.Address;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.Student;

public class whiteTestFactory {

	
	public static  Student createStudent(int id , String name, Address address) {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setAddress(address);
		
		return student;
		
	}
	
	public static Address createAddress(String street , String city , int codePost) {
		
		Address address = new Address();
		address.setCity(city);
		address.setStreet(street);
		address.setCodePost(codePost);
		return address;
	}
	
	public static Exam createExam(String code, String name) {
		Exam exam = new Exam();
		exam.setCode(code);
		exam.setName(name);
		return exam;
	}
	
}
