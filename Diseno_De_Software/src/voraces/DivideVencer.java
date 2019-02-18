package voraces;

import java.util.Scanner;

public class DivideVencer {

	static double intervaloA = 0;
	static double intervaloB = 0;
	static double medio = 0;
	static int[] valores;
	static Scanner sc = new Scanner(System.in);

	public static void coeficientes() {

		int coeficiente;
		int grado;

		System.out.println("Ingrese el grado:");
		grado = sc.nextInt();

		valores = new int[grado + 1];
		grado = valores.length - 1;

		for (int i = 0; i < valores.length; i++) {

			System.out.println("Ingrese el el coeficiente para X^" + grado--);
			coeficiente = sc.nextInt();
			valores[i] = coeficiente;

		}
		
		// intervalos
		System.out.println("Ingrese el intervalo a:");
		intervaloA = sc.nextDouble();
		System.out.println("Ingrese el intervalo b:");
		intervaloB = sc.nextDouble();

	}


	public static void verificarNoPositivos() {

		// Varificar que no son postivos
		if (f(intervaloA) * f(intervaloB) > 0) {

			System.out.println("No es posible localizar un punto medio.");

		} else {

			recursividad(medio, intervaloA, intervaloB);

		}

	}
	
	// Formula
	public static double f(double x) {

		double resultado = 0;
		int exp = valores.length - 1;

		for (int i = 0; i < valores.length; i++) {

			int coeficiente = valores[i];
			resultado += (coeficiente * Math.pow(x, exp));
			exp--;

		}

		return resultado;
	
	}

	public static void recursividad(double m, double a, double b) {

		m = (a + b) / 2;

		if (Math.abs(f(m)) <= 0.001) {

			System.out.println("Valor de corte en eje X: " + m);
			return;

		}

		if (f(a) * f(m) < 0) {

			b = m;

		} else {

			a = m;
		}

		recursividad(m, a, b);
	}

	public static void main(String[] args) {

		//Solicitud variables
		coeficientes();
		verificarNoPositivos();
		
	}	
}