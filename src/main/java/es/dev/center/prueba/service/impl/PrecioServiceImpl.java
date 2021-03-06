package es.dev.center.prueba.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dev.center.prueba.dao.PrecioDAO;
import es.dev.center.prueba.model.Precio;
import es.dev.center.prueba.service.PrecioService;

@Service
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
	public Iterable<Precio> findByCocheFecha(Long idCoche, Date fecha) {
		return precioDAO.findByCocheFecha(idCoche, fecha);
	}

}
