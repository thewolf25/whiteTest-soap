package de.tekup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.loan.soap.api.consume.whitetest.ExamListRequest;
import de.tekup.loan.soap.api.consume.whitetest.GetExamList;
import de.tekup.loan.soap.api.consume.whitetest.StudentRequest;
import de.tekup.loan.soap.api.consume.whitetest.WhiteTestResponse;
import de.tekup.services.WhiteTestClientService;

@Controller
public class WhiteTestController {
	@Autowired
	private WhiteTestClientService WTservice;
	
	@GetMapping("/reserve/whitetest")
	public String getWhiteTest( Model model) {
		StudentRequest request= new StudentRequest();
		model.addAttribute("request", request);
		return "studentrequest";
	}
	
	
	
	
	@PostMapping("/reserve/whitetest")
	public String getWhiteTest(@ModelAttribute("request") StudentRequest request, Model model) {
		WhiteTestResponse response = (WhiteTestResponse) WTservice.getWhiteTest(request);
		model.addAttribute("response", response);
		return "studentresponse";
	}
	
	@GetMapping("/exam/list")
	public String getExamList( Model model) {
		ExamListRequest request= new ExamListRequest();
		GetExamList response = (GetExamList) WTservice.getExamList(request);
		model.addAttribute("response", response);
		return "examlist";
	}
	
}
