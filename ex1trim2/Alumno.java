package ex1trim2;

import java.util.Scanner;

public class Alumno {
	//Atributos
	private String nombre;
	private int numeroFaltas;
	private int numeroClasesTotales;
	private boolean evaluacion;
	private double[] notas; 
	
	//Constructores
	//Vacio
	public Alumno() {
		nombre = "fulanito";
		numeroFaltas = 0;
		numeroClasesTotales = 100;
		evaluacion = false;
		notas = new double[4];
		for (int i = 0; i < notas.length; i++) {
			notas[i] = -1;
		}
	}
	//Nombre y numero de faltas por parámetro
	public Alumno(String nombre, int numeroFaltas) {
		this.nombre = nombre;
		this.numeroFaltas = numeroFaltas;
		numeroClasesTotales = 100;
		evaluacion = false;
		notas = new double[4];
		for (int i = 0; i < notas.length; i++) {
			notas[i] = -1;
		}
	}
	//Con todos los atributos por parámetros
	public Alumno(String nombre, int numeroFaltas, int numeroClasesTotales, boolean evaluacion, double[] notas) {
		this.nombre = nombre;
		this.numeroFaltas = numeroFaltas;
		this.numeroClasesTotales = numeroClasesTotales;
		this.evaluacion = evaluacion;
		this.notas = new double[notas.length];
		for (int i = 0; i < notas.length; i++) {
			this.notas[i] = notas[i];
		}
	}
	
	//Getters
	public String getNombre() {
		return nombre;
	}
	public int getNumeroFaltas() {
		return numeroFaltas;
	}
	public int getNumeroClasesTotales() {
		return numeroClasesTotales;
	}
	public boolean getEvaluacion() {
		return evaluacion;
	}
	
	//Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNumeroFaltas(int numeroFaltas) {
		this.numeroFaltas = numeroFaltas;
	}
	public void setNumeroClasesTotales(int numeroClasesTotales) {
		this.numeroClasesTotales = numeroClasesTotales;
	}
	
	//Método Calcular Faltas
	
	public void calculoDeFaltas() {
		if(numeroFaltas < (numeroClasesTotales * 30) / 100) {
			evaluacion = true;
		}
		else {
			evaluacion = false;
		}
	}
	
	//Método rellenar notas
	public void rellenarNotas(Scanner tcld) {
		int i = 0;
		double notaAuxiliar = 0;
		if(evaluacion) {
			while(i < 4) {
				System.out.println("Introduce la nota nº " + (i + 1));
				notaAuxiliar = tcld.nextDouble();
				if(notaAuxiliar >= 0 && notaAuxiliar <= 10) {
					notas[i] = notaAuxiliar;
					i++;
				}
				else {
					i = 4;
				}		
			}
		}
		else {
			System.out.println("Sin derecho a notas.");
		}
		//tcld.close();
	}
	
	//Método calcular nota final
	public double calcularNotaFinal() {
		double notaFinal = 0;
		double sumaNotas = 0;
		int contadorNotas = 0;
		calculoDeFaltas();
		if(evaluacion) {
			for (int i = 0;  i < notas.length; i++) {
				if(notas[i] >= 0 && notas[i] <= 10) {
					sumaNotas += notas[i];
					contadorNotas++;
				}
			}
			notaFinal = sumaNotas/contadorNotas;
		}
		else {
			System.out.println("Número de faltas: " + numeroFaltas + ". Excedido el límite. Sin derecho a nota");
			notaFinal = 0;
		}
		
		
		
		return notaFinal;
	}
	
	//Metodo mostrar toda la información por pantalla
	public void generarReporte() {
		System.out.println("Generando reporte del alumno [ " + nombre + " ]");
		System.out.println("Total de Clases: " + numeroClasesTotales);
		System.out.println("Total de Faltas: "+ numeroFaltas);
		if(evaluacion) {
			System.out.println("Derecho a Evaluación: Sí.");
			System.out.println("Nota media: " + (int) calcularNotaFinal());
			System.out.println("Nota media: " + Math.round(calcularNotaFinal()));
			
		}
		else {
			System.out.println("Derecho a Evaluación: No.");
		}
		
	}
	
	//Método imprimir piramide
	public void piramide() {
		int nota = (int) calcularNotaFinal();
		if( nota > 5) {
			for(int i = nota; i > 0 ; i--) {
				for(int j = 1; j <= i; j++) {
					System.out.print('*');
				}
				System.out.println();
			}
		}
		else {
			for(int i = 0; i < nota ; i++) {
				for(int j = 0; j <= i; j++) {
					System.out.print('*');
				}
				System.out.println();
			}
		}
	}
}

