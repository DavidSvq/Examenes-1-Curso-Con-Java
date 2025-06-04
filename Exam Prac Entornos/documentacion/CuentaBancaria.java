package documentacion;
/**
 * <h1>Clase CuentaBancaria<h1>
 * Esta clase se encarga de controlar una cuenta bancaria individual
 * 
 * @author David
 * @since 1.0
 * @version 2.1
 */
public class CuentaBancaria {
	//atributos
	/**
	 * Esta clase contiene 3 atributos: 
	 * 	- Titular contiene un String donde se indica el nombre de la persona titular.
	 * 	- Saldo contiene un double donde se indica el saldo actual de la cuenta corriente expresado en Euros.
	 * 	- Tasa Interes Anual contiene un double donde se indica el coste anual por tener la cuenta abierta.
	 */
	private String titular;
	private double saldo;
	private double tasaInteresAnual;

	//Constructores
	/**
	 * Este constructor contiene todos los atributos existentes pasados por parámetros
	 * @param titular, contiene el nombre en un String
	 * @param saldo, contiene el saldo de la cuenta en un double
	 * @param tasaInteresAnual, contiene el porcentaje que se cobra por mantener una cuenta activa.
	 */
	public CuentaBancaria(String titular, double saldo, double tasaInteresAnual) {
		this.titular = titular; 
		this.saldo = saldo;
		this.tasaInteresAnual = tasaInteresAnual;
	}

	//Get y set
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getTasaInteresAnual() {
		return tasaInteresAnual;
	}

	public void setTasaInteresAnual(double tasaInteresAnual) {
		this.tasaInteresAnual = tasaInteresAnual;
	}
	
	
	//Otros métodos
	/**
	 * Este método permite ingresar dinero en efectivo en la cuenta.
	 * @param cantidad, contiene la cantidad en un doble que se desea ingresar en cuenta.
	 * @return devuelve un double con el saldo actualizado tras sumar el ingreso.
	 */
	public double depositar(double cantidad) {

		if (cantidad > 0) {
			this.saldo += cantidad;
		}

		return this.saldo;
	}
	/**
	 * Este método permite retirar dinero en efectido de la cuenta.
	 * @param cantidad, contiene la cantidad en un doble que resta tras la retirada.
	 */
	public double retirar(double cantidad) {
		if (cantidad > 0 && cantidad < this.saldo) {
			this.saldo -= cantidad;
		}

		return this.saldo;
	}
	/**
	 * Este método nos permite calcular el coste de los intereses en euros.
	 * @return Devuelve un double con la cantidad en euros que supone la tasa de interés anual
	 */
	public double calcularInteresesAnuales() {
		return this.saldo * this.tasaInteresAnual / 100;
	}

	/**
	 * Este método nos permite generar un estracto de la cuenta para poder visualizarlo
	 * @return, nos devuelve información sobre el estado de la cuenta, indicando el titular, su saldo y tasa de interés anual
	 */
	public String generarExtracto() {
		return "Titular: " + this.titular + "\nSaldo: " + this.saldo + "\nTasa de Interés Anual: "
				+ this.tasaInteresAnual + "%";
	}
}
