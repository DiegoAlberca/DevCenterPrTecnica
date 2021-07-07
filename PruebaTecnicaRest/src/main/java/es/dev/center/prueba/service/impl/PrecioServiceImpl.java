package es.dev.center.prueba.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.dev.center.prueba.dao.PrecioDAO;
import es.dev.center.prueba.model.Precio;
import es.dev.center.prueba.service.PrecioService;

public class PrecioServiceImpl implements PrecioService{

	@Autowired
	private PrecioDAO precioDAO;
	
	@Override
	public Iterable<Precio> findAll() {
		return precioDAO.findAll();
	}

	@Override
	public Optional<Precio> findById(Long idPrecio) {
		return precioDAO.findById(idPrecio);
	}

	@Override
	public Optional<Precio> findByCocheFecha(Long idCoche, Date fecha) {
		return Optional.of(precioDAO.findByCocheFecha(idCoche, fecha));
	}

}
