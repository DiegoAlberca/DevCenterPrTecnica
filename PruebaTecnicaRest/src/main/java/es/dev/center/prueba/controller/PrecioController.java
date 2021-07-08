package es.dev.center.prueba.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.dev.center.prueba.dto.PrecioDTO;
import es.dev.center.prueba.model.ApiCalls;
import es.dev.center.prueba.model.ServiceEnum;
import es.dev.center.prueba.service.PrecioService;

@RestController
@RequestMapping("precios")
public class PrecioController {
	
	Logger logger = LoggerFactory.getLogger(PrecioController.class);
	
	@Autowired
	private PrecioService precioService;
	
	@GetMapping("/fecha")
	public List<PrecioDTO> getPrecioByCocheFecha(
			HttpServletRequest request,
			@RequestParam(value = "fecha") Date fecha, 
			@RequestParam(value = "idCoche") Long idCoche) {
		
		List<PrecioDTO> listaPrecios = new ArrayList<>();
		
		try {
			precioService.findByCocheFecha(idCoche, fecha)
				.forEach(a -> listaPrecios.add(new PrecioDTO(a)));
			
		} catch (Exception e) {
			logger.error("Se ha producido un error al consultar los datos de los precios ");
			logger.debug("ERROR [PrecioController.getPrecioByCocheFecha]");
		}
		
		ApiCalls apiCalls = new ApiCalls();
		apiCalls.setIp(request.getRemoteAddr());
		apiCalls.setFecha(new Date());
		apiCalls.setService(ServiceEnum.PRECIOS_FECHA);
		
		return listaPrecios;
	}
}
