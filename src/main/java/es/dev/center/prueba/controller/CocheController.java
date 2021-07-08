package es.dev.center.prueba.controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dev.center.prueba.dto.Response;
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

	@GetMapping
	public ResponseEntity<Response> getCochesFilter(
			HttpServletRequest request,
			@Param(value = "filter") String filter) {
		
		List<Coche> listaCoches = null;
		
		try {
			apiCallsService.saveApiCall(request, ServiceEnum.COCHES_FILTRO);
		} catch (Exception e) {
			Response resp = new Response();
			resp.setTexto("Se ha producido un error al guardar el log");
			resp.setDatos(new ArrayList<>());
			return ResponseEntity.internalServerError().body(resp);
		}
		
		if (filter != null) {
			if (filter.startsWith(Constantes.MARCA_EQUALS)) {
				String params = filter.substring(Constantes.MARCA_EQUALS.length()+1);
				listaCoches = cocheService.findByMarca(params);
				
			} else if (filter.contains(Constantes.COLOR_EQUALS)) {
				String params = filter.substring(filter.lastIndexOf(Constantes.COLOR_EQUALS));
				listaCoches = cocheService.findByColor(params);

			} else if (filter.contains(Constantes.MODELO_EQUALS)) {
				String params = filter.substring(filter.lastIndexOf(Constantes.MODELO_EQUALS));
				listaCoches = cocheService.findByModelo(params);
				
			} else if (filter.contains(Constantes.PRECIO_GREATER_THAN)) {
				try {
					String params = filter.substring(filter.lastIndexOf(Constantes.PRECIO_GREATER_THAN));		
					listaCoches = cocheService.findByMenosPrecio(Integer.valueOf(params));
				} catch (NumberFormatException e) {
					Response resp = new Response();
					resp.setTexto("El valor introducido para filtrar no es valido");
					resp.setDatos(new ArrayList<>());
					return ResponseEntity.badRequest().body(resp);
				}
				
			} else if (filter.contains(Constantes.PRECIO_LESS_THAN)) {
				try {
					String params = filter.substring(filter.lastIndexOf(Constantes.PRECIO_LESS_THAN));
					listaCoches = cocheService.findByMasPrecio(Integer.valueOf(params));
				} catch (NumberFormatException e) {
					Response resp = new Response();
					resp.setTexto("El valor introducido para filtrar no es valido");
					resp.setDatos(new ArrayList<>());
					return ResponseEntity.badRequest().body(resp);
				}
				
			} else {
				Response resp = new Response();
				resp.setTexto("No se ha encontrado ningun filtro con los parametros introducidos");
				resp.setDatos(new ArrayList<>());
				return ResponseEntity.badRequest().body(resp);
			}
			
		} else {
			Response resp = new Response();
			resp.setTexto("No se ha encontrado el parámetro filter");
			resp.setDatos(new ArrayList<>());
			return ResponseEntity.badRequest().body(resp);
		}
		
		Response resp = new Response();
		resp.setDatos(listaCoches);
		resp.setTexto("Peticion procesada correctamente");
		
		return ResponseEntity.badRequest().body(resp);
	}
	
	@GetMapping("/excel")
	public ResponseEntity<InputStreamResource> getCochesExcel() {
		
		ByteArrayInputStream stream = null;
		try {
			stream = cocheService.exportData();
		} catch (Exception e) {
			logger.error("Ha ocurrido un error al generar el fichero PDF");
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=coches.xls");
		
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
		
	}
}
