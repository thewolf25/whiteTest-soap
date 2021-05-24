package de.tekup.soap.endpoints;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.soap.models.whitetest.ExamListRequest;
import de.tekup.soap.models.whitetest.GetExamList;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import de.tekup.soap.services.ExamListService;
import de.tekup.soap.services.WhiteTestService;

@Endpoint
public class WhiteTestEndpoint {
	public static final String nameSpace="http://www.tekup.de/soap/models/whitetest";

	@Autowired
	private WhiteTestService service;
	
	@Autowired
	private ExamListService examService;
	
	
	@PayloadRoot(namespace = nameSpace, localPart = "StudentRequest")
	@ResponsePayload
	public WhiteTestResponse getLoanStatus(@RequestPayload StudentRequest studentRequest) throws DatatypeConfigurationException {
//		WhiteTestResponse ws = new ObjectFactory().createWhiteTestResponse();
//		ws.setStudent(new Student(studentRequest.getStudentId(),null,null));
//		return ws;
	
		
		return service.getWhiteTest(studentRequest);
	}
	
	@PayloadRoot(namespace = nameSpace , localPart = "ExamListRequest")
	@ResponsePayload
	public GetExamList getExamList(@RequestPayload ExamListRequest exmExamListRequest) {
		return examService.getExamList();
	
	}
	
	
	
	
	
}
