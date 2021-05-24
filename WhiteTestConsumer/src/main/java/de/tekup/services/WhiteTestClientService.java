package de.tekup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import de.tekup.loan.soap.api.consume.whitetest.ExamListRequest;
import de.tekup.loan.soap.api.consume.whitetest.GetExamList;
import de.tekup.loan.soap.api.consume.whitetest.StudentRequest;
import de.tekup.loan.soap.api.consume.whitetest.WhiteTestResponse;

@Service
public class WhiteTestClientService {
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate templte;
	
	public WhiteTestResponse getWhiteTest(StudentRequest request) {
		templte = new WebServiceTemplate(marshaller);
		
		WhiteTestResponse response = (WhiteTestResponse) templte.marshalSendAndReceive("http://localhost:8080/models", request);
		return response;
	}
	
	public GetExamList getExamList(ExamListRequest request) {
		templte = new WebServiceTemplate(marshaller);
		
		GetExamList response = (GetExamList) templte.marshalSendAndReceive("http://localhost:8080/models", request);
		return response;
	}
	
	
	
	
	
}
