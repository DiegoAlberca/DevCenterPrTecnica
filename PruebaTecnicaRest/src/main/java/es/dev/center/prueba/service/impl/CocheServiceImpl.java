package es.dev.center.prueba.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dev.center.prueba.dao.CocheDAO;
import es.dev.center.prueba.model.Coche;
import es.dev.center.prueba.service.CocheService;

@Service
public class CocheServiceImpl implements CocheService{

	@Autowired
	private CocheDAO cocheDAO;
	
	@Override
	public Iterable<Coche> findAll() {
		return cocheDAO. findAll();
	}

	@Override
	public Optional<Coche> findById(Long idCoche) {
		return cocheDAO.findById(idCoche);
	}

}
