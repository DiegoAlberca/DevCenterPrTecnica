package es.dev.center.prueba.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import es.dev.center.prueba.model.Coche;
import es.dev.center.prueba.service.CocheService;
import es.dev.center.prueba.service.PrecioService;

@RestController
@RequestMapping("coches")
public class CocheController {
	
	Logger logger = LoggerFactory.getLogger(CocheController.class);
	
	@Autowired
	private CocheService cocheService;

	
	public List<Coche> getCochesFilter(@RequestParam(value = "filter") String filter) {

		
		return null;
	}
	
	@GetMapping("/excel")
	public ResponseEntity<InputStreamResource> getCochesExcel() {
		ByteArrayInputStream stream = cocheService.exportData();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=coches.xls");
		
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
		
	}
}
