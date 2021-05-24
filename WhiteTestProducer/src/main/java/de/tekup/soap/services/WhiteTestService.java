package de.tekup.soap.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import de.tekup.factories.whiteTestFactory;
import de.tekup.soap.models.whitetest.Address;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Service
public class WhiteTestService {
	public static List<Student> students = new <Student>ArrayList();
	public static List<Exam> Exams = new <Exam> ArrayList();
//	static {
//		students.add(new Student(1,"safa",new Address("mourouj street","tunis",2014)));
//		students.add(new Student(2,"mehdi",new Address("ariana street","tunis",2015)));
//		students.add(new Student(3,"akrem",new Address("gafsa street","tunis",2016)));
//		students.add(new Student(4,"oussema",new Address("ghazela street ","tunis",2017)));
//		students.add(new Student(5,"omar",new Address("jerba street","tunis",2018)));		
//		Exams.add(new Exam("1z0-808","OCA"));
//		Exams.add(new Exam("1z0-809","OCP"));
//		Exams.add(new Exam("EX200","RHCSA"));
//		Exams.add(new Exam("EX300","RHCE"));
//	}
	
	static {
		students.add(whiteTestFactory.createStudent(1, "safa", whiteTestFactory.createAddress("mourouj street", "tunis", 2014)));
		students.add(whiteTestFactory.createStudent(2, "mehdi", whiteTestFactory.createAddress("ariana street","tunis",2015)));
		students.add(whiteTestFactory.createStudent(3, "akrem", whiteTestFactory.createAddress("gafsa street","tunis",2016)));
		students.add(whiteTestFactory.createStudent(4, "oussema", whiteTestFactory.createAddress("ghazela street ","tunis",2017)));
		students.add(whiteTestFactory.createStudent(5, "omar", whiteTestFactory.createAddress("jerba street","tunis",2018)));
		Exams.add(whiteTestFactory.createExam("1z0-808","OCA"));
		Exams.add(whiteTestFactory.createExam("1z0-809","OCP"));
		Exams.add(whiteTestFactory.createExam("EX200","RHCSA"));
		Exams.add(whiteTestFactory.createExam("EX300","RHCE"));
	}
	
	public WhiteTestResponse getWhiteTest(StudentRequest studentRequest) throws DatatypeConfigurationException {
		WhiteTestResponse whiteTestResponse = new ObjectFactory().createWhiteTestResponse();
		List<String> badRequests = whiteTestResponse.getBadRequests();
		Student s = new Student();
		s.setId(studentRequest.getStudentId());
		Exam exam = new Exam();
		exam.setCode(studentRequest.getExamCode());
		
//		if(! students.contains(s)) {
//			badRequests.add("Student not found !! ");
//		}
		if(students.stream().filter(st -> st.getId() == s.getId()).count() == 0) {
			badRequests.add("Student not found !! ");
		}
		
		
		
//		if(! Exams.contains(exam)) {
//			badRequests.add("Exam not found !! ");
//		}
		
		if(Exams.stream().filter(st -> st.getCode().equals(exam.getCode()) ).count() == 0) {
			badRequests.add("Exam not found !! ");
		}
		
		if(badRequests.isEmpty()) {
			whiteTestResponse.setDate(this.getDate());
			whiteTestResponse.setStudent(students.get(students.indexOf(s)));
			whiteTestResponse.setExam(Exams.get(Exams.indexOf(exam)));
			
		}
		
		
		return whiteTestResponse;
	}
	
	
	public XMLGregorianCalendar getDate() throws DatatypeConfigurationException {
		LocalDateTime localdateExam = LocalDateTime.of(LocalDate.now().plusDays(7), LocalTime.of(new Random().nextInt(7)+10, 0));
		ZonedDateTime zoneDateTime =
			     ZonedDateTime.of(localdateExam, ZoneId.systemDefault());
		
		
		GregorianCalendar gregorianCalendar =
			     GregorianCalendar.from(zoneDateTime);
					
			     //Creating XMLGregorianCalendar instance
			     XMLGregorianCalendar xmlGregorianCalendar =
			     DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(gregorianCalendar);
				return xmlGregorianCalendar;

	}
	
}
