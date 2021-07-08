package es.dev.center.prueba.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dev.center.prueba.dao.ApiCallsDAO;
import es.dev.center.prueba.model.ApiCalls;
import es.dev.center.prueba.model.ServiceEnum;
import es.dev.center.prueba.service.ApiCallsService;

@Service
public class ApiCallsServiceImpl implements ApiCallsService {

	@Autowired
	private ApiCallsDAO apiCallsDAO;

	@Override
	public void saveApiCall(HttpServletRequest request, ServiceEnum service) {
		ApiCalls apiCall = new ApiCalls();
		apiCall.setIp(request.getRemoteAddr());
		apiCall.setFecha(new Date());
		apiCall.setService(service);
		apiCallsDAO.save(apiCall);
	}

}
