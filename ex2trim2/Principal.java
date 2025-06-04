package ex1trim2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner tcld = new Scanner(System.in);
		VideoJuego vd = new VideoJuego("Alex Kid", "Aventura", 25.6, 7);
		VideoJuego vd1 = new VideoJuego ("Tetris", "Otros géneros", 53, 6);
		
		//Uso método toString
		System.out.println(vd.toString());
		
		//Uso método es caro
		boolean esCaro = vd.esCaro();
		if(esCaro) {
			System.out.println("El juego es caro.");
		}
		else {
			System.out.println("El juego es barato.");
		}
		
		//Uso método mejorar puntuación
		System.out.println("Puntuación: " + vd.getPuntuacion());
		vd.mejorarPuntuacion(2);
		System.out.println("Puntuación tras el aumento: " + vd.getPuntuacion());
		
		//Uso método calcular media puntuaciones
		System.out.println("Puntuación: " + vd.getPuntuacion());
		vd.calcularMediaPuntuaciones(3, tcld);
		System.out.println("Puntuación actual tras los ingresos: " + vd.getPuntuacion());
		
		//Uso método aplicar descuento
		System.out.println("Precio: " + vd.getPrecio());
		vd.aplicarDescuento(3);
		System.out.println("Precio tras aplicar el 3% de dto: " + vd.getPrecio());
		
		//Uso método generar código del juego
		int codigo = vd.generarCodigoJuego();
		System.out.println("Código del juego: " + codigo);
		
		//Uso método generar rebaja aleatoria
		vd.generarRebajaAleatoria();
		
		//Uso método calcular horas de juego
		vd.calcularHorasDeJuego();
		//VideoJuego2
		//Uso método toString
		System.out.println(vd1.toString());
		
		//Uso método es caro
		boolean esCaro1 = vd1.esCaro();
		if(esCaro1) {
			System.out.println("El juego es caro.");
		}
		else {
			System.out.println("El juego es barato.");
		}
		
		//Uso método mejorar puntuación
		System.out.println("Puntuación: " + vd1.getPuntuacion());
		vd1.mejorarPuntuacion(2);
		System.out.println("Puntuación tras el aumento: " + vd1.getPuntuacion());
		
		//Uso método calcular media puntuaciones
		System.out.println("Puntuación: " + vd.getPuntuacion());
		vd1.calcularMediaPuntuaciones(3, tcld);
		System.out.println("Puntuación actual tras los ingresos: " + vd1.getPuntuacion());
		
		//Uso método aplicar descuento
		System.out.println("Precio: " + vd1.getPrecio());
		vd1.aplicarDescuento(3);
		System.out.println("Precio tras aplicar el 3% de dto: " + vd1.getPrecio());
		
		//Uso método generar código del juego
		int codigo1 = vd1.generarCodigoJuego();
		System.out.println("Código del juego: " + codigo1);
		
		//Uso método generar rebaja aleatoria
		vd1.generarRebajaAleatoria();
		
		//Uso método calcular horas de juego
		vd1.calcularHorasDeJuego();
		tcld.close();
	}

}
