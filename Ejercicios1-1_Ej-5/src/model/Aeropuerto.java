package model;

public class Aeropuerto {
	private int id;
	private int anio_inauguracion;
	private int capacidad;
	private AeropuertoPrivado aPrivado;
	private String nombre;
	private Direccion direccion;
	private AeropuertoPublico aPublico;

	public Aeropuerto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnio_inauguracion() {
		return anio_inauguracion;
	}

	public void setAnio_inauguracion(int anio_inauguracion) {
		this.anio_inauguracion = anio_inauguracion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public AeropuertoPrivado getaPrivado() {
		return aPrivado;
	}

	public void setaPrivado(AeropuertoPrivado aPrivados) {
		this.aPrivado = aPrivados;
	}

	public AeropuertoPublico getaPublico() {
		return aPublico;
	}

	public void setaPublico(AeropuertoPublico aPublico) {
		this.aPublico = aPublico;
	}

	
	
}