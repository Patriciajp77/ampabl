package com.ampa.bl.bl.util;

public class ValidacionDNI {
	/**
	 * Este método comprobará la longitud del dni = 9 caracteres, que los 8 primeros
	 * caracteres sean números, y que el último caracter sea una letra.
	 */

	private String dni;

	public ValidacionDNI(String dni) {
		this.dni = dni;
	}

	// validar:
	public boolean validar() {

		String letraMayuscula;

		if (dni.length() != 9 || Character.isLetter(this.dni.charAt(8)) == false) {
			// System.out.println("El string no tiene 9 caracteres y/o el último caracter no
			// es una letra.");
			return false;
		}

		letraMayuscula = (this.dni.substring(8)).toUpperCase();

		if (numerosDni() == true && letraDni().equals(letraMayuscula)) {
			// System.out.println("El string tiene 8 números y una letra, que además
			// coincide con la calculada.");
			return true;
		} else {
			// System.out.println("El string no tiene 8 números o la letra no coincide con
			// la calculada");
			return false;
		}

	}

	// Números:

	private boolean numerosDni() {
		int i, j = 0;
		// Numero lo usaré, para saber si hay alguna letra entre los 8 primeros.
		String numero = "";
		// Cadena guarda los números, que pasará al método letraDni.
		String miDni = "";
		String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		for (i = 0; i < this.dni.length() - 1; i++) {

			numero = this.dni.substring(i, i + 1);

			for (j = 0; j < numeros.length; j++) {

				if (numero.equals(numeros[j])) {

					miDni += numeros[j];
				}
			}
		}

		if (miDni.length() != 8) {
			// System.out.println("No hay 8 números.");
			return false;
		} else {
			return true;
		}

	}

	// Cálculo letra dni:

	private String letraDni() {
		int miDni = Integer.parseInt(this.dni.substring(0, 8));
		int resto = 0;
		String letra = "";
		String[] letras = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
				"H", "L", "C", "K", "E" };

		resto = miDni % 23;

		letra = letras[resto];
		return letra;
	}
}
