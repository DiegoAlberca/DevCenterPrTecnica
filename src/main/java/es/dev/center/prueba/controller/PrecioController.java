package es.dev.center.prueba.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dev.center.prueba.dto.PrecioDTO;
import es.dev.center.prueba.dto.Response;
import es.dev.center.prueba.model.ServiceEnum;
import es.dev.center.prueba.service.ApiCallsService;
import es.dev.center.prueba.service.PrecioService;

@RestController
@RequestMapping("precios")
public class PrecioController {
	
	Logger logger = LoggerFactory.getLogger(PrecioController.class);
	
	@Autowired
	private PrecioService precioService;
	
	@Autowired
	private ApiCallsService apiCallsService;
	
	@GetMapping("/fecha")
	public ResponseEntity<Response> getPrecioByCocheFecha(
			HttpServletRequest request,
			@Param(value = "fecha") Date fecha, 
			@Param(value = "idCoche") Long idCoche) {
		
		List<PrecioDTO> listaPrecios = new ArrayList<>();
		
		try {
			apiCallsService.saveApiCall(request, ServiceEnum.PRECIOS_FECHA);
		} catch (Exception e) {
			Response resp = new Response();
			resp.setTexto("Se ha producido un error al guardar el log");
			resp.setDatos(new ArrayList<>());
			return ResponseEntity.internalServerError().body(resp);
		}
		
		if (fecha == null) {
			Response resp = new Response();
			resp.setTexto("No se ha encontrado el parámetro fecha");
			resp.setDatos(new ArrayList<>());
			return ResponseEntity.badRequest().body(resp);
		}
		
		if (idCoche == null) {
			Response resp = new Response();
			resp.setTexto("No se ha encontrado el parámetro idCoche");
			resp.setDatos(new ArrayList<>());
			return ResponseEntity.badRequest().body(resp);
		}
		
		try {
			precioService.findByCocheFecha(idCoche, fecha)
				.forEach(a -> listaPrecios.add(new PrecioDTO(a)));
			
		} catch (Exception e) {
			logger.error("Se ha producido un error al consultar los datos de los precios");
			
			Response resp = new Response();
			resp.setTexto("Se ha producido un error al consultar los datos de los precios");
			resp.setDatos(new ArrayList<>());
			return ResponseEntity.internalServerError().body(resp);
		}
		
		Response resp = new Response();
		resp.setDatos(listaPrecios);
		resp.setTexto("Peticion procesada correctamente");
		return ResponseEntity.ok().body(resp);
	}
}
