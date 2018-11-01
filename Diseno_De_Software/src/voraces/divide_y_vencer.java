package voraces;

import java.util.ArrayList;
import java.util.Scanner;

public class divide_y_vencer {
	
		static ArrayList<String> coeficientes = new ArrayList<String>();

		// Formula
		public static double f(double x, ArrayList<String> coeficientes) {
			int index = 0;
			double resultado = 0;
			for (int i = coeficientes.size(); i > 0; i--) {
				resultado += Double.parseDouble(coeficientes.get(index))*Math.pow(x, i-1);
				index++;
			}
			return resultado;
			
		}
		
		public static void recursividad(double m, double a, double b) {
		
				m = (a + b) / 2;
				if (Math.abs(f(m,coeficientes)) <= 0.001) {
//					System.out.println("Valor de m en corte:" + f(m));
					System.out.println("Valor de corte en eje X: " + m);
					return;
				}
				if (f(a,coeficientes) * f(m,coeficientes) < 0) 
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
			int grado = 0;
			
			System.out.println("Ingrese el intervalo a:");
			a = sc.nextDouble();
			System.out.println("Ingrese el intervalo b:");
			b = sc.nextDouble();
			System.out.println("Ingrese el grado:");
			grado = sc.nextInt();
			
			for (int n = 0; n < (grado+1); n++) {
				System.out.println("Ingrese el coeficiente # " + (n + 1));
				coeficientes.add(sc.next());
			}

			// Varificar que no son postivos
			if (f(a,coeficientes) * f(b,coeficientes) > 0) {
				System.out.println("No es posible localizar un punto medio.");
			} else {
				recursividad(m, a, b);
			}

		}
	
}
