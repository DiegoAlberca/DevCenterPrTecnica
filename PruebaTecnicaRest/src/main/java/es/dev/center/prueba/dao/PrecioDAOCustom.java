package es.dev.center.prueba.dao;

import java.util.Date;
import java.util.Optional;

import es.dev.center.prueba.model.Precio;

public interface PrecioDAOCustom {
	public Precio findByCocheFecha(Long coche, Date fecha);

}
