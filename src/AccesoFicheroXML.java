import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AccesoFicheroXML {
	
	public static Clima parsearXML() {
		SAXBuilder builder=new SAXBuilder();
		Document documento;
		Clima c=null;
		try {
			documento = builder.build(new File("C:\\Jessica\\aemet.xml"));
			Element elemento_raiz=documento.getRootElement();
			Element elemento_nombre=elemento_raiz.getChild("nombre");//Nombre es el municipio
			String nombre=elemento_nombre.getValue();
			Element elemento_provincia=elemento_raiz.getChild("provincia");
			String provincia=elemento_provincia.getValue();
			System.out.println("Municipio: "+nombre+"\t"+"Provincia: "+provincia);
			Element elemento_prediccion=elemento_raiz.getChild("prediccion");
			String prediccion=elemento_prediccion.getValue();
			List<Element> lista_elementos_dia=elemento_prediccion.getChildren("dia");
			ArrayList<Dia> lista_dias=new ArrayList<>();//Para construir objeto
			for (int j= 0; j < lista_elementos_dia.size(); j++) 
			{
				Element elemento_dia = lista_elementos_dia.get(j);
				Attribute atributo_fecha=elemento_dia.getAttribute("fecha");
				String fecha_rara=atributo_fecha.getValue();
				Element elemento_temperatura=elemento_dia.getChild("temperatura");
				Element elemento_t_minima=elemento_temperatura.getChild("minima");
				Element elemento_t_maxima=elemento_temperatura.getChild("maxima");
				String t_minima=elemento_t_minima.getValue();
				String t_maxima=elemento_t_maxima.getValue();
				System.out.println("Dia: "+atributo_fecha.getValue()+"\t"+"Temperatura minima: "+elemento_t_minima.getValue()+"\t"+"Temperatura maxima: "+elemento_t_maxima.getValue());
				Dia d=new Dia(fecha_rara,Integer.parseInt(t_minima),Integer.parseInt(t_maxima));
			}
			c=new Clima(nombre,provincia,lista_dias);
			
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}
