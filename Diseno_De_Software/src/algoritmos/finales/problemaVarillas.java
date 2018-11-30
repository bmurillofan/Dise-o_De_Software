package algoritmos.finales;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author bmurillo, jramos
 *
 */
public class problemaVarillas {

	/*
	 * OBtiene el el valor optimo para la longitud en la que se desea dividir la varilla
	 * 
	 */
	static double tamanioMatriz = 0;
	static ArrayList<Integer> partes = new ArrayList<Integer>();
	static ArrayList<Integer> valores = new ArrayList<Integer>();
	static int valorTmp = 0;
	static int copiaValor = 0;
	
	static int divisionVarilla(ArrayList<Integer> precio, int tamanio) {
		// Se crea varialbe de memorización
		int val[] = new int[tamanio + 1];
		
		val[0] = 0;
		
		
		//Se reccore hasta el maximo tamaño especificado del cual se quiere obtener el valor optimo
		for (int i = 1; i <= tamanio; i++) {
			//Se inicializa la variable del valor maximo.
			int valorMaximo = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				//Se obtienen los precios para la posición J
				//Luego se suma a el valor contenido en el arreglo de memorización que se encuentre en la posición [i-j-1]
				
				valorMaximo = Math.max(valorMaximo, precio.get(j) + val[i - j - 1]);
				
			    valorTmp = precio.get(j);
			}
			
			copiaValor = valorMaximo;
			//El valor maximo recuperado se agrega al arreglo de memorización
			val[i] = valorMaximo;
			
		}
		partes.add(valorTmp);
		valores.add(copiaValor);

		return val[tamanio];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el tamaño de la matriz de costos:");
		tamanioMatriz = sc.nextDouble();

		//Se agregan 
		ArrayList<Integer> costos = new ArrayList<>();
		for (int i = 0; i < tamanioMatriz; i++) {
			System.out.println("Agrege el precio para el corte con longitud # " + (i + 1));
			costos.add(sc.nextInt());
			
		}
		
		System.out.print("\nLongitud: | ");
		for (int i = 0; i < costos.size(); i++) {
			System.out.print(" " + (i +1) + " |");
			
		}
		System.out.print("\nPrecio: | ");
		for (int i = 0; i < costos.size(); i++) {
			System.out.print(" " + costos.get(i) + " |");
		}
		System.out.println("\n\nIngrese el tamaño de la varilla para la cual obtener el valor optimo:");
		int tamanioVarilla = sc.nextInt();
		
		System.out.println("Y la solución óptima seria cortar la varilla en dos piezas de longitud " + divisionVarilla(costos, tamanioVarilla));

	}

}
