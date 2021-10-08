package model;

public class Participacion {
	private int id_deportista, id_evento, id_equipo, edad;
	private String medalla;
	
	public Participacion() {
		// TODO Auto-generated constructor stub
	}

	public int getId_deportista() {
		return id_deportista;
	}

	public void setId_deportista(int id_deportista) {
		this.id_deportista = id_deportista;
	}

	public int getId_evento() {
		return id_evento;
	}

	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}

	public int getId_equipo() {
		return id_equipo;
	}

	public void setId_equipo(int id_equipo) {
		this.id_equipo = id_equipo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getMedalla() {
		return medalla;
	}

	public void setMedalla(String medalla) {
		this.medalla = medalla;
	}
	
	
}
