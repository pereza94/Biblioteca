package entity;

import java.sql.Date;

public class Sancion {
	private Integer numSancion;
	private Integer cantDias;
	private Socio dniSocio;
	private Date fechaInicio;
	private Date fechaFin;
	private int dni;
	public Integer getNumSancion() {
		return numSancion;
	}
	public void setNumSancion(Integer numSancion) {
		this.numSancion = numSancion;
	}
	public Integer getCantDias() {
		return cantDias;
	}
	public void setCantDias(Integer cantDias) {
		this.cantDias = cantDias;
	}
	public Socio getDniSocio() {
		return dniSocio;
	}
	public void setDniSocio(Socio dniSocio) {
		this.dniSocio = dniSocio;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
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




}
