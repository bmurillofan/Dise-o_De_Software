package voraces;
import java.util.Scanner;

public class Problema1 {

	public static void main(String[] args) {
		int anchoM1;
		int altoM2;
		int nPiezas;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese tamaño M1 (Ancho)");
		anchoM1 = sc.nextInt();
		System.out.println("Ingrese tamaño M2 (Alto)");
		altoM2 = sc.nextInt();
		System.out.println("Ingrese la cantidad de piezas");
		nPiezas = sc.nextInt();
		int[] piezasi = new int[nPiezas];
		int[] piezasj = new int[nPiezas];
		int[] piezasb = new int[nPiezas];
		for (int i = 0; i < piezasi.length; i++) {
			System.out.println("Ingrese el valor de i para la Pieza #" + (i+1) );
			piezasi[i] = sc.nextInt();
		}
		for (int j = 0; j < piezasj.length; j++) {
			System.out.println("Ingrese el valor de j para la Pieza #" + (j+1) );
			piezasj[j] = sc.nextInt();
		}
		
		for (int o = 0; o < piezasb.length; o++) {
			System.out.println("Ingrese el valor de b para la pareja #" + (o+1) );
			piezasb[o] = sc.nextInt();
		}
		
		
		
		double[] beneficios = new double[nPiezas];
		for (int n = 0; n < beneficios.length; n++) {
			beneficios[n] = (double)piezasb[n] / (double)(piezasi[n]*piezasj[n]);
		}
		
		System.out.println("Resumen de datos cargados:");
		System.out.println("");
		System.out.println("Ancho: " + anchoM1);
		System.out.println("Alto: " + altoM2);
		System.out.println("Espacio de matriz: " + (anchoM1*altoM2) );
		System.out.println("Cantidad de piezas: "+ nPiezas);
		
		System.out.println("Espacios para i: " );
		for (int item : piezasi) {
		    System.out.print(item + "   ");
		}
		System.out.println("");
		
		System.out.println("Espacios para j: " );
		for (int item : piezasj) {
		    System.out.print(item + "   ");
		}
		System.out.println("");
		
		System.out.println("Beneficios" );
		for (int item : piezasb) {
		    System.out.print(item + "   ");
		}
		System.out.println("");
		
		// Algoritmo
		
		int totalLleno = anchoM1*altoM2;
		int indexBeneficioMayor = 0;
		double valorBeneficioMayor = beneficios[0];
		double beneficioTotal = 0;
		String piezas = "Parejas # ";
		String benefi = "Benefi # ";
		while (totalLleno != 0 && totalLleno > 0) {
			valorBeneficioMayor = beneficios[0];
			indexBeneficioMayor = 0;
			for (int i = 0; i < beneficios.length; i++) {
				if (valorBeneficioMayor < beneficios[i]) {
					valorBeneficioMayor = beneficios[i];
					indexBeneficioMayor = i;
				}
			}
			
			if ( (piezasi[indexBeneficioMayor]*piezasj[indexBeneficioMayor]) <= totalLleno ) {
				totalLleno = totalLleno - (piezasi[indexBeneficioMayor]*piezasj[indexBeneficioMayor]);
				beneficioTotal = beneficioTotal + beneficios[indexBeneficioMayor];
				piezas = (indexBeneficioMayor+1) + "-";
				benefi = piezasb[indexBeneficioMayor] + "-";
				piezasi[indexBeneficioMayor] = anchoM1*altoM2;
				piezasj[indexBeneficioMayor] = anchoM1*altoM2;
				beneficios[indexBeneficioMayor] = 0;
			}
		
		
		}
		
		System.out.println("Beneficio Total: " + beneficioTotal);
		System.out.println("Piezas: " + piezas);
		System.out.println("Beneficios Individuales: " + benefi);
	}

}
