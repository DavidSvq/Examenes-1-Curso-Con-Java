package examen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LibroUtils {
	
	//Método formatear título
	public static String formatearTitulo(String titulo) {
		String tituloFormateado = titulo.toUpperCase();
		return tituloFormateado;
	}
	
	//Método filtrar por longitud de palabras
	public static ArrayList<String> filtrarPalabrasLargas(String texto, int letrasMin){
		//Creación del escaner para separar las palabras
		Scanner lectorTexto = new Scanner(texto);
		
		//Colecciones usadas en el método
		ArrayList<String> palabras = new ArrayList<>();
		ArrayList<String> palabrasLargas = new ArrayList<>();
		
		//Bucle para rellenar una lista con las palabras
		while(lectorTexto.hasNext()) {
			palabras.add(lectorTexto.next());
		}
		
		//Rellenar una nueva lista, la que será devuelta, con las palabras que cumplen la condición
		for (String palabra : palabras) {
			if(palabra.length() > letrasMin) {
				palabrasLargas.add(palabra);
			}
		}
		return palabrasLargas;
	}
	
	//Método contar palabras titulos libros
	public static HashMap<String, Integer> analizarPalabrasClave(ArrayList<Libro> libros){
		//Creacion de colecciones y mapas usados en el método
		HashMap<String, Integer> palabrasRepetidasEnTitulos = new HashMap<>();
		ArrayList<String> palabrasTitulo = new ArrayList<>();
		
		//Creación del escaner para la separación de palabras
		Scanner lectorTitulos;
		
		//Bucle para sacar las palabras de cada título
		for (Libro libro : libros) {
			lectorTitulos = new Scanner(libro.getTitulo());
			while(lectorTitulos.hasNext()) {
				String siguientePalabra = lectorTitulos.next().toLowerCase();
				if(siguientePalabra.length() > 3) {
					palabrasTitulo.add(siguientePalabra);
				}
				
			}
		}
		
		//Bucle para pasar las palabras como clave a un mapa, el valor se usa de contador
		for (String palabra : palabrasTitulo) {
			palabrasRepetidasEnTitulos.put(palabra, palabrasRepetidasEnTitulos.getOrDefault(palabra, 0) + 1);
		}
		
		return palabrasRepetidasEnTitulos;
	}
}
