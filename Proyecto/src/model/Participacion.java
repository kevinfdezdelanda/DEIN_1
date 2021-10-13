package model;

public class Participacion {
	private int edad;
	private Evento evento;
	private Deportista deportista;
	private Equipo equipo;
	private String medalla;
	
	public Participacion() {
		// TODO Auto-generated constructor stub
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Deportista getDeportista() {
		return deportista;
	}

	public void setDeportista(Deportista deportista) {
		this.deportista = deportista;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Deportista: "+deportista.getNombre()+" | Equipo: "+equipo.getNombre()+"-"+equipo.getIniciales()+" | Edad: "+edad+" | Medalla: "+medalla;
	}
}
