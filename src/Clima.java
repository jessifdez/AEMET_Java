import java.util.ArrayList;

public class Clima {
	private String nombre, provincia;
	private ArrayList<Dia> dia;
	
	
	public Clima(String nombre, String provincia, ArrayList<Dia> dia) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.dia = dia;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public ArrayList<Dia> getDia() {
		return dia;
	}
	public void setDia(ArrayList<Dia> dia) {
		this.dia = dia;
	}
	
	
	

}
