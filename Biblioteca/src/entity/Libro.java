package entity;

import java.util.List;

public class Libro {
	private Autor autor;
	private String materia;
	private String edicion;
	private Integer anio;
	private String isbn;
	private Reserva reservaEnLibro;
	private List<Ejemplar> numEjemplar;
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
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
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
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
	
	
	

}
