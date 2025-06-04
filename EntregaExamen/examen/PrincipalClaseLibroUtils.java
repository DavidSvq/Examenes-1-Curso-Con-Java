package examen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrincipalClaseLibroUtils {

	public static void main(String[] args) {
		ArrayList<Libro> libros = new ArrayList<>();
		libros.add(new Libro("1", "aaaaaaa fue y no fue", "aaaaaa", 2000));
		libros.add(new Libro("3", "zzzzzzz vino y vino", "zzzzzz", 2004));
		libros.add(new Libro("4", "ddddddd casi y no casi", "dddddd", 2006));
		libros.add(new Libro("5", "fffffff fue", "ffffff", 2008));
		libros.add(new Libro("2", "bbbbbbb vino y pan", "bbbbbb", 2002));
		
		
		//Comprobar método formatearTitulo
		System.out.println(LibroUtils.formatearTitulo("aaaaaaa"));
		
		//Comprobar método filtrar por longitud de palabras
		String texto = "texto para prueba del ejercicio dos";
		//LibroUtils.filtrarPalabrasLargas(texto, 3);
		System.out.println(LibroUtils.filtrarPalabrasLargas(texto, 3));
		
		//Comprobar método contar palabras titulos libros
		HashMap<String, Integer> palabrasRepe = new HashMap<>();
		palabrasRepe = LibroUtils.analizarPalabrasClave(libros);
		
		//Bucle para imprimir el mapa
		for (Map.Entry<String, Integer> entry : palabrasRepe.entrySet()) {
			String clave = entry.getKey();
			Integer valor = entry.getValue();
			
			System.out.println(clave + " " + valor);
			
		}
	}

}
