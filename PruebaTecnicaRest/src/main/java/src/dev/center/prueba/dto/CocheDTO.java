package src.dev.center.prueba.dto;

import java.util.Date;

public class CocheDTO {
	
	private Long idCoche;
	private Long idMarca;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer precio;
	
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
