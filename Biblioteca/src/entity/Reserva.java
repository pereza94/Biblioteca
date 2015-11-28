package entity;

import java.util.Date;

public class Reserva {
	private Date fechaRegistro;
	private Date fechaFin;
	private int dni;
	private int codEjemplar;
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
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getCodEjemplar() {
		return codEjemplar;
	}
	public void setCodEjemplar(int codEjemplar) {
		this.codEjemplar = codEjemplar;
	}


}
