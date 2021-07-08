package es.dev.center.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dev.center.prueba.dao.ApiCallsDAO;
import es.dev.center.prueba.model.ApiCalls;
import es.dev.center.prueba.service.ApiCallsService;

@Service
public class ApiCallsServiceImpl implements ApiCallsService {

	@Autowired
	private ApiCallsDAO apiCallsDAO;
	
	@Override
	public ApiCalls saveApiCall(ApiCalls apiCall) {
		return apiCallsDAO.save(apiCall);
	}

}
