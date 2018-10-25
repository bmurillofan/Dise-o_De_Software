package voraces;
import java.util.*; 

public class parcial_2 {

	public static void main(String[] args) {
		// Crear ArrayList
		 ArrayList<Integer> arrli = new ArrayList<Integer>(); 
		 ArrayList<Integer> arrli = new ArrayList<Integer>(); 
		 int numeroTareas;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Ingrese la cantidad de Tareas (Numero)");
		 numeroTareas = sc.nextInt();
		 System.out.println("Tareas Creadas..");
		 int[] ganancias= new int [numeroTareas];
		 int[] tiemposUnitarios= new int [numeroTareas];

		 for (int n = 0; n < ganancias.length; n++) {
		 System.out.println("Ingrese la Ganancia para la tarea # " + (n+1) );
		 ganancias[n] = sc.nextInt();
		 System.out.println("Ingrese el tiempo unitario para la tarea # " + (n+1) );
		 tiemposUnitarios[n] = sc.nextInt();
		 }

		 System.out.println("Resumen de datos cargados-------------------------------");
		 System.out.println("");
		 System.out.println("Cantidad de tareas: " + numeroTareas);
		 System.out.println("Ganacias por tarea para (gi): " );
		 for (int item : ganancias) {
		 System.out.print(item + " ");
		 }
		 System.out.println("");

		 System.out.println("Tiempo Unitario por tarea para (ti): " );
		 for (int item : tiemposUnitarios) {
		 System.out.print(item + " ");
		 }
		 System.out.println("");


		 // Algoritmo

		 // Buscar menor tiempo de tarea

		 int indexMenorTarea = 0;

		 for (int i = 0; i < tiemposUnitarios.length; i++) {

		 if (tiemposUnitarios[indexMenorTarea] > tiemposUnitarios[i] ) {
		 indexMenorTarea = i;
		 }

		 }

		 String [] conjuntoTiempos;
		 int contador = 0;

		 for (int i = 0; i < tiemposUnitarios.length; i++) {
		 if (tiemposUnitarios[i] == tiemposUnitarios[indexMenorTarea]) {
		 contador++;
		 }
		 }
		 conjuntoTiempos = new String [contador];

		 for (int i = 0; i < conjuntoTiempos.length; i++) {
		 if (tiemposUnitarios[i] == tiemposUnitarios[indexMenorTarea]) {
		 conjuntoTiempos [i] = String.valueOf(tiemposUnitarios[i] + ',' + String.valueOf(ganancias[i]));
		 }
		 }

		 // Buscar mayor beneficio

		 int indexMayorBeneficio = 0;

		 for (int i = 0; i < conjuntoTiempos.length ; i++) {


		 if ( Integer.parseInt(conjuntoTiempos[indexMayorBeneficio].split(",")[1]) > Integer.parseInt(conjuntoTiempos[i].split(",")[1]) ) {
		 indexMayorBeneficio = i;
		 }

		 }
	}

}
