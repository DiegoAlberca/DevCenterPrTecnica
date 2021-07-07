package es.dev.center.prueba.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.dev.center.prueba.model.Precio;
import es.dev.center.prueba.service.PrecioService;
import src.dev.center.prueba.dto.CocheDTO;

@RestController
@RequestMapping("coches")
public class CocheController {
	
	@Autowired
	private PrecioService precioService;
	
	@GetMapping("/fecha")
	public CocheDTO getCocheFecha(
			@RequestParam(value = "fecha") Date fecha, 
			@RequestParam(value = "idCoche") Long idCoche) {
		
		Precio precio = precioService.findByCocheFecha(idCoche, fecha).get();
		
		CocheDTO cocheDTO = new CocheDTO();
		cocheDTO.setIdCoche(precio.getCoche().getId());
		cocheDTO.setIdMarca(precio.getCoche().getMarca().getId());
		cocheDTO.setFechaInicio(precio.getFechaInicio());
		cocheDTO.setFechaFin(precio.getFechaFin());
		cocheDTO.setPrecio(precio.getPrecio());
		
		return cocheDTO;
	}
}
