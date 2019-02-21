import java.util.ArrayList;

public class EntradaSalida {
	
	public static void mostrarDatos(Clima c) {
		System.out.println("La temperatura en "+c.getNombre()+", provincia de "+c.getProvincia()+" para los pr�ximos d�as ser�: \n"+c.getDia());
		for(Dia d : c.getDia())
		{
			System.out.println(formatearfecha(d.getFecha())+"\t"+d.getT_minima()+" �C"+"\t"+d.getT_maxima()+" �C");
		}
		
	}

	private static String formatearfecha(String fecha) {
		String[] campos=fecha.split("-");
		String fecha_formateada=campos[2]+"/"+campos[1]+"/"+campos[0];
		return fecha_formateada;
	}

	
	

}
