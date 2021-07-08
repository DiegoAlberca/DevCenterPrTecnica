package es.dev.center.prueba.controller;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.dev.center.prueba.model.ApiCalls;
import es.dev.center.prueba.model.Coche;
import es.dev.center.prueba.model.ServiceEnum;
import es.dev.center.prueba.service.ApiCallsService;
import es.dev.center.prueba.service.CocheService;
import es.dev.center.prueba.utiles.Constantes;

@RestController
@RequestMapping("coches")
public class CocheController {
	
	Logger logger = LoggerFactory.getLogger(CocheController.class);
	
	@Autowired
	private CocheService cocheService;
	
	@Autowired
	private ApiCallsService apiCallsService;

	
	public List<Coche> getCochesFilter(
			HttpServletRequest request,
			@RequestParam(value = "filter") String filter) {
			
		if (filter.startsWith(Constantes.MARCA_EQUALS)) {
			String params = filter.substring(filter.lastIndexOf(Constantes.MARCA_EQUALS));
			cocheService.findByColor(params);
			
		} else if (filter.contains(Constantes.COLOR_EQUALS)) {
			String params = filter.substring(filter.lastIndexOf(Constantes.COLOR_EQUALS));
			cocheService.findByColor(params);

		} else if (filter.contains(Constantes.MODELO_EQUALS)) {
			String params = filter.substring(filter.lastIndexOf(Constantes.MODELO_EQUALS));
			cocheService.findByModelo(params);
			
		} else if (filter.contains(Constantes.PRECIO_GREATER_THAN)) {
			String params = filter.substring(filter.lastIndexOf(Constantes.PRECIO_GREATER_THAN));
//			cocheService.findByMenosPrecio(params);
			
		} else if (filter.contains(Constantes.PRECIO_LESS_THAN)) {
			String params = filter.substring(filter.lastIndexOf(Constantes.PRECIO_LESS_THAN));
//			cocheService.findByMasPrecio(params);
			
		} else {
			
		}
		
		ApiCalls apiCall = new ApiCalls();
		apiCall.setIp(request.getRemoteAddr());
		apiCall.setFecha(new Date());
		apiCall.setService(ServiceEnum.PRECIOS_FECHA);
		apiCallsService.saveApiCall(apiCall);
		
		
		return null;
	}
	
	@GetMapping("/excel")
	public ResponseEntity<InputStreamResource> getCochesExcel() {
		
		ByteArrayInputStream stream = null;
		try {
			stream = cocheService.exportData();
		} catch (Exception e) {
			
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=coches.xls");
		
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
		
	}
}
