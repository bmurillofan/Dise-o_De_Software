package voraces;

import java.util.Scanner;

public class divide_y_vencer {

		// Formula
		public static double f(double x) {
			return Math.pow(x, 3) + (2 * Math.pow(x, 2)) - 5;
		}
		
		public static void recursividad(double m, double a, double b) {
		
				m = (a + b) / 2;
				if (Math.abs(f(m)) <= 0.001) {
//					System.out.println("Valor de m en corte:" + f(m));
					System.out.println("Valor de corte en eje X: " + m);
					return;
				}
				if (f(a) * f(m) < 0) 
				b = m;
				else
				a = m;
				
				recursividad(m, a, b);
		}

		public static void main(String[] args) {

			// Imports
			Scanner sc = new Scanner(System.in);

			// Variables
			double m = 0;
			double a = 0;
			double b = 2;

			System.out.println("Ingrese el intervalo a:");
			a = sc.nextDouble();
			System.out.println("Ingrese el intervalo b:");
			b = sc.nextDouble();

			// Varificar que no son postivos
			if (f(a) * f(b) > 0) {
				System.out.println("No es posible localizar un punto medio.");
			} else {
				recursividad(m, a, b);
			}

		}
	
}
