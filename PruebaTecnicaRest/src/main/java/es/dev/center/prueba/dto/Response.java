package es.dev.center.prueba.dto;

public class Response {
	private Integer codigoRespuesta;
	private String textoRespuesta;
	private Object datos;
	
	public Integer getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(Integer codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getTextoRespuesta() {
		return textoRespuesta;
	}
	public void setTextoRespuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}
	public Object getDatos() {
		return datos;
	}
	public void setDatos(Object datos) {
		this.datos = datos;
	}
	
	
}
