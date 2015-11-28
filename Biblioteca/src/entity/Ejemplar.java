package entity;

import java.sql.Date;

public class Ejemplar {
	private Integer numInventario;
	private boolean estado;
	private String isbn;
	private String codUbicaion;
	private Date fechaAlta;
	public Integer getNumInventario() {
		return numInventario;
	}
	public void setNumInventario(Integer numInventario) {
		this.numInventario = numInventario;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCodUbicaion() {
		return codUbicaion;
	}
	public void setCodUbicaion(String codUbicaion) {
		this.codUbicaion = codUbicaion;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}




}
