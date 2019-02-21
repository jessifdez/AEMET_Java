import java.util.ArrayList;

public class AEMET {

	public static void main(String[] args) {
		Clima c=AccesoFicheroXML.parsearXML();
		EntradaSalida.mostrarDatos(c);
	}

}
