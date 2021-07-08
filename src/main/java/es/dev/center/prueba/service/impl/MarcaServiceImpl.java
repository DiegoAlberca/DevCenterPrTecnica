package es.dev.center.prueba.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dev.center.prueba.dao.MarcaDAO;
import es.dev.center.prueba.model.Marca;
import es.dev.center.prueba.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService{

	@Autowired
	private MarcaDAO marcaDAO;
	
	@Override
	public Iterable<Marca> findAll() {
		return marcaDAO.findAll();
	}

	@Override
	public Optional<Marca> findById(Long idMarca) {
		return marcaDAO.findById(idMarca);
	}

}
