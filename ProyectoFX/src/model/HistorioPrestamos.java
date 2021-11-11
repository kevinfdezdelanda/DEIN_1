package model;

import java.sql.Date;

public class HistorioPrestamos {
	private int id_prestamo;
	private Alumno alumno;
	private Libro libro;
	private Date fecha_prestamo, fecha_devolucion;
	
	public HistorioPrestamos() {
		// TODO Auto-generated constructor stub
	}

	public HistorioPrestamos(int id_prestamo, Alumno alumno, Libro libro, Date fecha_prestamo, Date fecha_devolucion) {
		super();
		this.id_prestamo = id_prestamo;
		this.alumno = alumno;
		this.libro = libro;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
	}

	public int getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
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

	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_prestamo;
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
		if (id_prestamo != other.id_prestamo)
			return false;
		return true;
	}
	
	
}
