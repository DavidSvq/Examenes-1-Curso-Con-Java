package romeroDavid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TiendaApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> titulos = new ArrayList<>();
		ArrayList<String> plataformas = new ArrayList<>();
		ArrayList<String> isbnes = new ArrayList<>();
		ArrayList<Articulo> articulos = new ArrayList<>();
		boolean todoOk = false;
		int opcionMenu = 0;
		
		titulos.add("Alex Kid");
		titulos.add("Pang");
		titulos.add("Street Figther");
		titulos.add("Fifa");
		titulos.add("ProEvolu Soccer");
		
		plataformas.add("Pc");
		plataformas.add("PS5");
		plataformas.add("Xbox");
		plataformas.add("GameBoy");
		plataformas.add("Swithf");
		
		isbnes.add("1234567890123");
		isbnes.add("2234567890123");
		isbnes.add("3234567890123");
		isbnes.add("4234567890123");
		isbnes.add("5234567890123");
		
		
		try {
			VideoJuego vd1 = new VideoJuego(titulos.get((int)(Math.random() * 4)), (int) (Math.random() * 100), plataformas.get((int)(Math.random() * 4)));
			VideoJuego vd2 = new VideoJuego(titulos.get((int)(Math.random() * 4)), (int) (Math.random() * 100), plataformas.get((int)(Math.random() * 4)));
			VideoJuego vd3 = new VideoJuego(titulos.get((int)(Math.random() * 4)), (int) (Math.random() * 100), plataformas.get((int)(Math.random() * 4)));
			
			Libro l1 = new Libro(titulos.get((int)(Math.random() * 4)), (int) (Math.random() * 100),isbnes.get((int)(Math.random() * 4)));
			Libro l2 = new Libro(titulos.get((int)(Math.random() * 4)), (int) (Math.random() * 100),isbnes.get((int)(Math.random() * 4)));
			
			
			articulos.add(vd1);
			articulos.add(vd2);
			articulos.add(vd3);
			articulos.add(l1);
			articulos.add(l2);
		}
		catch(ArticuloNoValidoException e){
			System.out.println(e);
		}
		while(opcionMenu != 9) {
			todoOk = false;
			while(!todoOk) {
				try {
					do {
					System.out.println("Pulse la opción deseada: ");
					System.out.println("1 Para nuevo articulo videojuego");
					System.out.println("2 Para nuevo articulo libro");
					System.out.println("3 Para mostrar lista");
					System.out.println("4 Para ordenar ");
					System.out.println("5 Para ordenar por Precio e id");
					System.out.println("6 Para ordenar por tipo y titulo");
					System.out.println("7 Para ordenar por nota");				
					System.out.println("8 Para ver la media de precios");
					System.out.println("9 Para salir");
					opcionMenu = sc.nextInt();
					}while(opcionMenu < 1 && opcionMenu > 9);
					todoOk = true;
					
					switch (opcionMenu) {
					case 1:
						articulos.add(new VideoJuego(titulos.get((int)(Math.random() * 4)), (int) (Math.random() * 100), plataformas.get((int)(Math.random() * 4))));
						break;
					case 2:
						articulos.add(new Libro(titulos.get((int)(Math.random() * 4)), (int) (Math.random() * 100), isbnes.get((int)(Math.random() * 4))));
						break;
					case 3:
						for (Articulo articulo : articulos) {
							System.out.println(articulo);
						}
						break;
					case 4:
						Collections.sort(articulos);
						break;
					case 5:
						Collections.sort(articulos, new PrecioEId());
						break;
					case 6:
						Collections.sort(articulos, new TipoYTitulo());
						break;
					case 7:
						Collections.sort(articulos, new PorNota());
						break;
					case 8:
						Articulo.precioMedioPorTipo(articulos);
						break;
					default:
						break;
					}
					
				}
				catch (InputMismatchException e1){
					System.out.println(e1 + "Introduce un entrero.");
					sc.nextLine();
				}
				catch(IndexOutOfBoundsException e2){
					System.out.println(e2);
				}
			}
		}
	}

}
