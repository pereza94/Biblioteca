package entity;

import java.util.List;

public class Socio {
	private Integer dniSocio;
	private String identidad;
	private String domicilio;
	private String sexo;
	private String telefono;
	private List<Reserva> reservaEnSocio;
	private List<Sancion> numSancion;
	
	
	
	public Integer getDniSocio() {
		return dniSocio;
	}
	public void setDniSocio(Integer dniSocio) {
		this.dniSocio = dniSocio;
	}
	public String getIdentidad() {
		return identidad;
	}
	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	
	public List<Sancion> getNumSancion() {
		return numSancion;
	}
	public void setNumSancion(List<Sancion> numSancion) {
		this.numSancion = numSancion;
	}
	public List<Reserva> getReservaEnSocio() {
		return reservaEnSocio;
	}
	public void setReservaEnSocio(List<Reserva> reservaEnSocio) {
		this.reservaEnSocio = reservaEnSocio;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}
