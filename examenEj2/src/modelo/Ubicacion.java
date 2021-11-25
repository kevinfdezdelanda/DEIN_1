package modelo;

public class Ubicacion {
	private int idUbic;
	private String seccion, ubicacion, imagen;
	
	public Ubicacion() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdUbic() {
		return idUbic;
	}
	public void setIdUbic(int idUbic) {
		this.idUbic = idUbic;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return seccion+" - "+ubicacion;
	}
	
}
