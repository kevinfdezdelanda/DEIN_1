package model;

import java.sql.Date;

public class Prestamo {
	private int id;
	private Alumno alumno;
	private Libro libro;
	private Date fechaPrestamo;
	
	public Prestamo() {
		// TODO Auto-generated constructor stub
	}

	public Prestamo(int id, Alumno alumno, Libro libro, Date fechaPrestamo) {
		super();
		this.id = id;
		this.alumno = alumno;
		this.libro = libro;
		this.fechaPrestamo = fechaPrestamo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
