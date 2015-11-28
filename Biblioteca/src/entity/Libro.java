package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Libro {
	private String autor;
	private String materia;
	private String edicion;
	private String editorial;
	private Date anio;
	private String titulo;
	private String isbn;
	private Reserva reservaEnLibro;
	private List<Ejemplar> numEjemplar;

	public String getAutor() {
		return autor;
	}
	public void setAutor(String string) {
		this.autor = string;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Reserva getReservaEnLibro() {
		return reservaEnLibro;
	}
	public void setReservaEnLibro(Reserva reservaEnLibro) {
		this.reservaEnLibro = reservaEnLibro;
	}
	public List<Ejemplar> getNumEjemplar() {
		return numEjemplar;
	}
	public void setNumEjemplar(List<Ejemplar> numEjemplar) {
		this.numEjemplar = numEjemplar;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public Date getAnio() {
		return anio;
	}
	public void setAnio(Date anio) {
		this.anio = anio;
	}




}
