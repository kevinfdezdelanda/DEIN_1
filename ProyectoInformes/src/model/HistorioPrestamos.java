package model;

import java.sql.Date;

public class HistorioPrestamos {
	private int idPrestamo;
	private Alumno alumno;
	private Libro libro;
	private Date fechaPrestamo, fechaDevolucion;
	
	public HistorioPrestamos() {
		// TODO Auto-generated constructor stub
	}

	public HistorioPrestamos(int id_prestamo, Alumno alumno, Libro libro, Date fecha_prestamo, Date fecha_devolucion) {
		super();
		this.idPrestamo = id_prestamo;
		this.alumno = alumno;
		this.libro = libro;
		this.fechaPrestamo = fecha_prestamo;
		this.fechaDevolucion = fecha_devolucion;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int id_prestamo) {
		this.idPrestamo = id_prestamo;
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

	public void setFechaPrestamo(Date fecha_prestamo) {
		this.fechaPrestamo = fecha_prestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fecha_devolucion) {
		this.fechaDevolucion = fecha_devolucion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPrestamo;
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
		HistorioPrestamos other = (HistorioPrestamos) obj;
		if (idPrestamo != other.idPrestamo)
			return false;
		return true;
	}
	
	
}
