package entity;

import java.util.Date;

public class Prestamo {
	
	private Socio dni;
	private Libro numEjemplar;
	private Date  fechaPrestamo;
	private Date  fechaLimite;
	private Date  fechaDevolución;
	private int dniSocio;
	private int numPrestamo;
	private int numEjemplarDB;
	
	
	public Socio getDni() {
		return dni;
	}
	public void setDni(Socio dni) {
		this.dni = dni;
	}
	public Libro getNumEjemplar() {
		return numEjemplar;
	}
	public void setNumEjemplar(Libro numEjemplar) {
		this.numEjemplar = numEjemplar;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public Date getFechaDevolución() {
		return fechaDevolución;
	}
	public void setFechaDevolución(Date fechaDevolución) {
		this.fechaDevolución = fechaDevolución;
	}
	public int getDniSocio() {
		return dniSocio;
	}
	public void setDniSocio(int dniSocio) {
		this.dniSocio = dniSocio;
	}
	public int getNumPrestamo() {
		return numPrestamo;
	}
	public void setNumPrestamo(int numPrestamo) {
		this.numPrestamo = numPrestamo;
	}
	public int getNumEjemplarDB() {
		return numEjemplarDB;
	}
	public void setNumEjemplarDB(int numEjemplarDB) {
		this.numEjemplarDB = numEjemplarDB;
	}

	
	
}
