package es.dev.center.prueba.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "api_calls")
public class ApiCalls {
	
	private String ip;
	private Date fecha;
	private ServiceEnum service;
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public ServiceEnum getService() {
		return service;
	}
	
	public void setService(ServiceEnum service) {
		this.service = service;
	}
	
}
