package es.dev.center.prueba.service;

import javax.servlet.http.HttpServletRequest;

import es.dev.center.prueba.model.ServiceEnum;

public interface ApiCallsService {

	public void saveApiCall(HttpServletRequest request, ServiceEnum service);
	
}
