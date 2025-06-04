package ex1trim2;

import java.util.Random;
import java.util.Scanner;

public class VideoJuego {
	//Atributos
	private String titulo;
	private String genero;
	private double precio;
	private int puntuacion;
	
	//Constructors
	//Vacio
	public VideoJuego() {
		
	}
	
	//Título y genero
	public VideoJuego(String titulo, String genero){
	this.titulo = titulo;
	this.genero = genero;
	precio = 0;
	puntuacion = 5;
	}
	
	//Todos los atributos
	public VideoJuego(String titulo, String genero, double precio, int puntuacion){
		this.titulo = titulo;
		this.genero = genero;
		this.precio = precio;
		this.puntuacion = puntuacion;
	}	
	//Getters 
	public String getTitulo() {
		return titulo;
	}
	public String getGenero() {
		return genero;
	}
	public double getPrecio() {
		return precio;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	
	//Setters
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	//Método toString
	public String toString() {
		return "[ Video Juego][Título: " + titulo + " | Genero: " + genero + " | Precio: " + precio + " | Puntuación: " + puntuacion + " ]";
	}
	
	//Método es caro
	public boolean esCaro() {
		boolean esCaro = false;
		if(precio > 50) {
			esCaro = true;
		}
		return esCaro;
	}
	
	//Método mejorar puntuación
	public void mejorarPuntuacion(int aumentoPuntuacion) {
		int nuevaPuntuacion = 0;
		nuevaPuntuacion = puntuacion + aumentoPuntuacion;
		if(nuevaPuntuacion <= 10) {
			puntuacion = nuevaPuntuacion;
		}
		else {
			System.out.println("Error puntuación límite excedida");
		}
	}
	
	//Método cálcular media puntuación
	public void calcularMediaPuntuaciones(int cantidadPuntuaciones, Scanner tcld) {
		int nuevaPuntuacion = 0;
		int sumaPuntuaciones = puntuacion;
		int contadorAuxiliarMedia = cantidadPuntuaciones;
		while(cantidadPuntuaciones > 0) {
			System.out.println("Introduce la puntuación: ");
			nuevaPuntuacion = tcld.nextInt();
			sumaPuntuaciones += nuevaPuntuacion;
			cantidadPuntuaciones --;
		}
		puntuacion = sumaPuntuaciones / (contadorAuxiliarMedia + 1); //Más 1 porque cuento la nota ya existente para cálcular la media.
	}
	
	//Método aplicar descuento
	public void aplicarDescuento(double porcentaje) {
		double descuento = 0;
		descuento = (precio * porcentaje) / 100;
		precio -= descuento;
		if(precio < 0) {
			System.out.println("No se puede aplicar el descuento.");
			precio += descuento;
		}
	}
	
	//Método generar código juego
	public int generarCodigoJuego() {
		Random aleatorio = new Random();
		int codigo = aleatorio.nextInt(100000000);
		return codigo;
	}
	
	//Método generar rebaja aleatoria
	public void generarRebajaAleatoria() {
		int porcentajeRebaja = (int) (Math.random() * 30 + 5);
		System.out.println("Descuento aleatorio: " + porcentajeRebaja);
		double descuento = 0;
		descuento = (precio * porcentajeRebaja) / 100;
		precio -= descuento;
		if(precio < 0) {
			System.out.println("No se puede aplicar el descuento.");
			precio += descuento;
		}
		else {
			System.out.println("Precio tras aplicar dto: " + precio);
		}
	}
	
	//Método cálcular horas de juegos
	public void calcularHorasDeJuego() {
		int horasRecomendadas = 0;
		if(genero == "RPG") {
			horasRecomendadas = (int) (Math.random()* 200 + 50);
			System.out.println("Horas recomendadas para " + genero + ": " + horasRecomendadas);
		}
		else if(genero == "Aventura") {
			horasRecomendadas = (int) (Math.random( )* 10 + 20);
			System.out.println("Horas recomendadas para " + genero + ": " + horasRecomendadas);
		}
		else if(genero == "Shooter") {
			horasRecomendadas = (int) (Math.random() * 50 + 10);
			System.out.println("Horas recomendadas para " + genero + ": " + horasRecomendadas);
		}
		else if(genero == "Sandbox") {
			horasRecomendadas = (int) (Math.random() * 500 + 100);
			System.out.println("Horas recomendadas para " + genero + ": " + horasRecomendadas);
		}
		else if(genero == "Otros géneros") {
			horasRecomendadas = (int) (Math.random() * 100 + 10);
			System.out.println("Horas recomendadas para " + genero + ": " + horasRecomendadas);
		}
	}
}
