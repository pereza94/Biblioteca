package entity;

import java.util.Date;

public class Reserva {
	private Date fechaRegistro;
	private Integer numReserva;
	private Socio socio;
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Integer getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(Integer numReserva) {
		this.numReserva = numReserva;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	
}
