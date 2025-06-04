package ex1trim2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner tcld = new Scanner(System.in);
		Alumno a1 = new Alumno("David", 2);
		Alumno a2 = new Alumno("Maria", 33);
		
		//USO DEL MÉTODO CÁLCULAR FALTAS
		//Alumno 1
		a1.calculoDeFaltas();
		System.out.println("ALUMNO 1");
		if(a1.getEvaluacion()) {
			System.out.println("Derecho a Evaluación: Sí.");
		}
		else {
			System.out.println("Derecho a Evaluación: No.");
		}
		
		//Alumno 2
		a2.calculoDeFaltas();
		System.out.println("ALUMNO 2");
		if(a2.getEvaluacion()) {
			System.out.println("Derecho a Evaluación: Sí.");
		}
		else {
			System.out.println("Derecho a Evaluación: No.");
		}
		
		//UUSO DEL MÉTODO RELLENAR NOTAS
		//Alumno 1
		System.out.println("NOTAS ALUMNO 1");
		a1.rellenarNotas(tcld);
		
		//Alumno 2 
		System.out.println("NOTAS ALUMNO 2");
		a2.rellenarNotas(tcld);
		
		//Uso del método cálcular nota final
		//Alumno 1
		a1.calcularNotaFinal();
		
		//Alumno 2
		a2.calcularNotaFinal();
		
		//USO DEL MÉTODO MOSTRAR INFORMACIÓN POR PANTALLA
		//Alumno 1
		System.out.println("INFORMACIÓN ALUMNO 1");
		a1.generarReporte();
		//Alumno 2
		System.out.println("INFORMACIÓN ALUMNO 2");
		a2.generarReporte();
		
		//USO DEL MÉTODO PIRÁMIDE
		a1.piramide();
	}

}
