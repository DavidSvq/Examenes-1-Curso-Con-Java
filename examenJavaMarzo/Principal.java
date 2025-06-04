package examenJavaMarzo;

public class Principal {

	public static void main(String[] args) {
		//CLASE TRANSPORTE
		//Creación de un objeto Transporte
		Transporte t = new Transporte("Sevilla", "Santander");
		
		//Método toString
		System.out.println(t);
		
		//Método calcular tiempo de viaje. 
		System.out.println("Tiempo de viaje: " + t.calcularTiempoViaje());
		
		//Método introducir viaje
		if(t.introducirViaje("Sevilla", "Huelva")) {
			System.out.println("Viaje válido");
		}
		else {
			System.out.println("Viaje no válido");
		}
		
		//CLASE TRANSPORTE TERRESTRE
		//Creación de un objeto Transporte Terrestre
		TransporteTerrestre tR = new TransporteTerrestre();
		
		//Método toString
		System.out.println(tR);
		
		//Método introducir matrícula
		if(tR.introducirMatricula("2345FTG")) {
			System.out.println("Matricula correcta");
		}
		else {
			System.out.println("Matricula incorrecta");
		}
		System.out.println(tR);
		
		//Método calcular tiempo viaje con distancia por parámetro
		System.out.println("Tiempo minutos: " + tR.calcularTiempoViaje(35));
		
		//Método calcular tiempo viaje con distancia y velocidad
		System.out.println("Tiempo minutos: " + tR.calcularTiempoViaje(40, 2));
		
		//Método calcular tiempo viaje sin parámetros
		System.out.println("Tiempo minutos: " + tR.calcularTiempoViaje());
		
		//CLASE TRANSPORTE AEREO
		//Creación de un objeto Transporte Aereo
		TransporteAereo tA = new TransporteAereo("Sevilla", "Huelva", 4);
		
		//Método generar ruta de vuelo
		System.out.println(tA.generarRutaVuelo());
		
		//Método calcular tiempo viaje con distancia por parámetro
		System.out.println("Tiempo minutos: " + tA.calcularTiempoViaje(600));
		
		//Método toString
		System.out.println(tA);
	}
}
