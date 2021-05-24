package de.tekup.soap.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.GetExamList;
import de.tekup.soap.models.whitetest.ObjectFactory;

@Service
public class ExamListService {
	
	public GetExamList getExamList() {
		GetExamList examList = new ObjectFactory().createGetExamList();
		List<Exam> exams = examList.getExamList();
		WhiteTestService.Exams.stream().forEach(s-> exams.add(s));		
		return examList;
		
	}

}
