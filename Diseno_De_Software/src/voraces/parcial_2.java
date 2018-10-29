package voraces;

import java.util.ArrayList;
import java.util.Scanner;

public class parcial_2 {

	public static void main(String[] args) {

		// Imports
		Scanner sc = new Scanner(System.in);

		// Doble Array tiempo / beneficio
		ArrayList<String> beneficios = new ArrayList<String>();
		ArrayList<String> tiemposUnitarios = new ArrayList<String>();
		ArrayList<String> agruparTiempos = new ArrayList<String>();
		ArrayList<String> resultadosExtraidos = new ArrayList<String>();
		// Cantidad de tareas
		int numeroTareas;
		
		
		

		System.out.println("Ingrese la cantidad de Tareas (Numero)");
		numeroTareas = sc.nextInt();
		System.out.println("Tareas Creadas..");

		
		
		
		for (int n = 0; n < numeroTareas; n++) {
			System.out.println("Ingrese la Ganancia para la tarea # " + (n + 1));
			beneficios.add(sc.next());
			System.out.println("Ingrese el tiempo unitario para la tarea # " + (n + 1));
			tiemposUnitarios.add(sc.next());
		}
		
		
		
		
		System.out.println("--------------Resumen de datos cargados--------------");
		System.out.println("");
		System.out.println("Cantidad de tareas: " + numeroTareas);
		System.out.println("Ganacias por tarea para (gi): " );
			
			for (String item : beneficios)
				System.out.print(item + " ");
			System.out.println("");
			
			System.out.println("Tiempo Unitario por tarea para (ti): " );
			
			for (String item : tiemposUnitarios)
				System.out.print(item + " ");
			System.out.println("");
			
		System.out.println("");
		
		
		
		
		// Algoritmo ******************************************************
		
		
		
		while (tiemposUnitarios.size() != 0) {
			// Buscar menor tiempo
			int indexMenorTarea = 0;
			for (int i = 0; i < tiemposUnitarios.size(); i++) {
				if (Integer.parseInt(tiemposUnitarios.get(indexMenorTarea)) > Integer.parseInt(tiemposUnitarios.get(i)))
					indexMenorTarea = i;
			}
			
			// Agrupar si hay más tiempos equivalentes al menor
																												//			int cantidadTiemposIguales = 0;
																												//			for (int i = 0; i < tiemposUnitarios.size(); i++) {
																												//				if (Integer.parseInt(tiemposUnitarios.get(indexMenorTarea)) == Integer.parseInt(tiemposUnitarios.get(i)))
																												//					cantidadTiemposIguales++;
																												//			}	
			for (int i = 0; i < tiemposUnitarios.size(); i++) {
				if (Integer.parseInt(tiemposUnitarios.get(indexMenorTarea)) == Integer.parseInt(tiemposUnitarios.get(i)))
					agruparTiempos.add( tiemposUnitarios.get(i) + ',' + beneficios.get(i) );
			}
			
			// Buscar mayor beneficio
			int indexMayorBeneficio = 0;
			for (int i = 0; i < agruparTiempos.size() ; i++) {
				if ( Integer.parseInt(agruparTiempos.get(indexMayorBeneficio).split(",")[1]) < Integer.parseInt(agruparTiempos.get(i).split(",")[1]))
					indexMayorBeneficio = i;
			}
			
			// Guardar 
			resultadosExtraidos.add(agruparTiempos.get(indexMayorBeneficio));
			
			
			// Clones Elinadores
			ArrayList<String> tiemposUnitariosCopiada = new ArrayList<String>(tiemposUnitarios);
			ArrayList<String> beneficiosCopiada = new ArrayList<String>(beneficios);
			tiemposUnitarios.clear();
			beneficios.clear();
			
			for (int i = 0; i < tiemposUnitariosCopiada.size(); i++) {
				if (Integer.parseInt(tiemposUnitariosCopiada.get(indexMenorTarea)) != Integer.parseInt(tiemposUnitariosCopiada.get(i))) {
					tiemposUnitarios.add(tiemposUnitariosCopiada.get(i));
					beneficios.add(beneficiosCopiada.get(i));
				}
			}
			tiemposUnitariosCopiada.clear();
			beneficiosCopiada.clear();
			
			agruparTiempos.clear();
			indexMenorTarea = 0;																													//			cantidadTiemposIguales = 0;
			indexMayorBeneficio = 0;
			for (String item : beneficios)
				System.out.print(item + " ");
			System.out.println("");
			for (String item : tiemposUnitarios)
				System.out.print(item + " ");
			System.out.println("");
	}
			
			//resultadosExtraidos.remove(resultadosExtraidos.size()-1);
			// Fin
		System.out.println("Resultados");
			for (String item : resultadosExtraidos) {
				System.out.print("Se ejecuta la tarea con tiempo: " + item.split(",")[0] + " Obteniendo una ganancia de: " + item.split(",")[1]);
				System.out.println();
			}
			System.out.println("");
			
	}

}
