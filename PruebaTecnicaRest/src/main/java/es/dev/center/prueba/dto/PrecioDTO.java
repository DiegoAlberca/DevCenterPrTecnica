package es.dev.center.prueba.dto;

import java.util.Date;

import es.dev.center.prueba.model.Precio;

public class PrecioDTO {
	
	private Long idCoche;
	private Long idMarca;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer precio;
	
	public PrecioDTO(Precio precio) {
		this.idCoche = precio.getCoche().getId();
		this.idMarca = precio.getCoche().getMarca().getId();
		this.fechaInicio = precio.getFechaInicio();
		this.fechaFin = precio.getFechaFin();
		this.precio = precio.getPrecio();
	}
	
	public PrecioDTO(Long idCoche, Long idMarca, Date fechaInicio, Date fechaFin, Integer precio) {
		this.idCoche = idCoche;
		this.idMarca = idMarca;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precio = precio;
	}

	public Long getIdCoche() {
		return idCoche;
	}
	
	public void setIdCoche(Long idCoche) {
		this.idCoche = idCoche;
	}
	
	public Long getIdMarca() {
		return idMarca;
	}
	
	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public Integer getPrecio() {
		return precio;
	}
	
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
}
