package examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

	public class InventarioLibros {
		// Abrimos el scanner
		static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) {
			
			//Colección usada
			ArrayList<Libro> libros = new ArrayList<>();

			boolean salir = false; // variable para elegir opción menú
			
			/*libros.add(new Libro("1", "aaaaaaa", "aaaaaa", 2000));
			libros.add(new Libro("3", "zzzzzzz", "zzzzzz", 2004));
			libros.add(new Libro("4", "ddddddd", "dddddd", 2006));
			libros.add(new Libro("5", "fffffff", "ffffff", 2008));
			libros.add(new Libro("2", "bbbbbbb", "bbbbbb", 2002));*/
			
			try {
				while (!salir) {
					System.out.println("\n--- MENÚ DE BIBLIOTECA ---");
					System.out.println("1. Agregar libro");
					System.out.println("2. Eliminar libro por ISBN");
					System.out.println("3. Listar todos los libros");
					System.out.println("4. Buscar libros por autor");
					System.out.println("5. Buscar libros por palabra en el título");
					System.out.println("6. Ordenar libros");
					System.out.println("7. Guardar libros en archivo");
					System.out.println("8. Cargar libros desde archivo");
					System.out.println("9. Salir");
					System.out.print("Elige una opción: ");
	
					int opcion = sc.nextInt();
					sc.nextLine(); // limpiar salto de línea
	
					switch (opcion) {
					case 1: {
						InventarioLibros.agregarLibro(libros);
						break;
					}
					case 2: {
						InventarioLibros.eliminarLibro(libros);
						break;
					}
					case 3: {
						InventarioLibros.listarLibros(libros);
						break;
					}
					case 4: {
						InventarioLibros.buscarPorAutor(libros);
						break;
					}
					case 5: {
						InventarioLibros.buscarPalabraEnTitulo(libros);
						break;
					}
					case 6: {
						Collections.sort(libros);
						break;
					}
					case 7: {
						InventarioLibros.guardaLibros(libros);
						break;
					}
					case 8: {
						libros = InventarioLibros.cargarLibros();
						break;
					}
					case 9:
						salir = true;
						System.out.println("Saliendo del programa...");
						break;
					default:
						System.out.println("Opción no válida. Inténtalo de nuevo.");
					}
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Error, introduce un número entero.");
			}
			//sc.close();
		}
		
		//Método case 1
		public static void agregarLibro(ArrayList<Libro> libros) {
			//Solicitar datos por teclado
			System.out.println("Introduce el Isbn: ");
			String isbnAux = sc.nextLine();
			System.out.println("Introduce el título: ");
			String tituloAux = sc.nextLine();
			System.out.println("Introduce el autor: ");
			String autorAux = sc.nextLine();
			System.out.println("Introduce el año de publicación: ");
			int anioPublicacionAux = sc.nextInt();
			
			//Agregar libro a la lista de libros
			libros.add(new Libro(isbnAux, tituloAux, autorAux,anioPublicacionAux));
			
		}
		
		//Método case 2 
		public static void eliminarLibro(ArrayList<Libro> libros) {
			//Solicitar el isbn por teclado
			System.out.println("Introduce el ISBN");
			String isbnAux = sc.nextLine();
			
			//Borrar libro por isbn
			libros.removeIf(elemento -> elemento.getIsbn().equalsIgnoreCase(isbnAux));
			
			//Variable para controlar el borrado.
			boolean libroNoEncontrado = false;
			
			//Bucle para confirmar el borrado
			for (Libro libro : libros) {
				if(!libro.getIsbn().contains(isbnAux)) {
					libroNoEncontrado = true;
				}
			}
			
			//Condicional para aviso de acción final realizada.
			if(libroNoEncontrado) {
				System.out.println("Libro borrado.");
			}
			else {
				System.out.println("El libro no se borró.");
			}
		}
		
		//Método case 3
		public static void listarLibros(ArrayList<Libro> libros) {
			
			//Compruebo si el arraylist esta vación
			if(libros.isEmpty()) {
				System.out.println("La lista de libros está vacia.");
			}
			else { //Sino lo imprimo
				System.out.println("Listado de libros: ");
				for (Libro libro : libros) {
					System.out.println(libro);
				}
			}
		}
		
		//Método case 4
		public static void buscarPorAutor(ArrayList<Libro> libros) {
			//Variable para controlar si se exite el autor
			boolean autorEntoncrado = false;
			
			//Solicitar autor por teclado.
			System.out.println("Introduce el autor: ");
			String autorAux = sc.nextLine();
			
			//Imprimir libros del autor
			System.out.println("Libros del autor " + autorAux);
			for (Libro libro : libros) {
				if(libro.getAutor().equalsIgnoreCase(autorAux)) {
					System.out.println(libro);
					autorEntoncrado = true;
				}
			}
			
			//Aviso si no se encuentra el autor
			if(!autorEntoncrado) {
				System.out.println("No se encontró el autor indicado.");
			}
					
		}
		
		//Método case 5
		public static void buscarPalabraEnTitulo(ArrayList<Libro> libros) {
			//Variable para comprobar si se encontró la palabra
			boolean palabraEncontrada = false;
			
			//Solicitud de la palabra a buscar
			System.out.println("Introduce una palabra: ");
			String palabraAux = sc.nextLine();
			palabraAux = palabraAux.toLowerCase();
			
			//Mostrar los libros que cumplan la condición anterior
			System.out.println("Títulos que contienen " + palabraAux);
			for (Libro libro : libros) {
				String tituloAux = libro.getTitulo().toLowerCase();
				if(tituloAux.contains(palabraAux)) {
					System.out.println(libro);
					palabraEncontrada = true;
				}
			}
			
			//Aviso si no se encontró la palabra 
			if(!palabraEncontrada) {
				System.out.println("No se encontró la palabra.");
			}
			
		}
		
		//Método case 7
		public static void guardaLibros(ArrayList<Libro> libros){
			try(BufferedWriter bw = new BufferedWriter(new FileWriter("libros.csv"))){
				for (Libro libro : libros) {
					bw.write(libro.getIsbn() + "," +
					libro.getTitulo() + "," +
					libro.getAutor() + "," + 
					libro.getAnioPublicacion());
					bw.newLine();
				}
			} catch (IOException e) {
				System.out.println("Error al guardar el archivo.");
			}
			
		}
		
		//Método case 8
		public static ArrayList<Libro> cargarLibros(){
			
			ArrayList<Libro> libros = new ArrayList<>();
			
			try(BufferedReader br = new BufferedReader(new FileReader("libros.csv"))){
				String linea;
				while((linea = br.readLine()) != null) {
					String [] atributos = linea.split(",");
					String isbn = atributos[0];
					String titulo = atributos[1];
					String autor = atributos[2];
					int anioPublicacion = Integer.parseInt(atributos[3]);
					
					Libro libro = new Libro(isbn, titulo, autor, anioPublicacion);
					libros.add(libro);
				}
			} catch (FileNotFoundException e) {
				System.out.println("Error, archivo no encontrado.");
			} catch (IOException e) {
				System.out.println("Error al leer el archivo.");
			}
			
			return libros;
		}
	
}
