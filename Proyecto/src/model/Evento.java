package model;

public class Evento {
	private int id;
	private Olimpiada olimpiada;
	private Deporte deporte;
	private String nombre;
	
	public Evento() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Olimpiada getOlimpiada() {
		return olimpiada;
	}

	public void setOlimpiada(Olimpiada olimpiada) {
		this.olimpiada = olimpiada;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	
	@Override
	public String toString() {
		return nombre+" - "+deporte.getNombre()+" - "+olimpiada.getNombre();
	}
}
