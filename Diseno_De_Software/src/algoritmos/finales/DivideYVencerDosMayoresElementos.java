package algoritmos.finales;

public class DivideYVencerDosMayoresElementos {
	public static void NumMasGrandes(int[] vector, int[] numgran, int contador){
        // comprobamos que no hemos llegado al final del vector
        if ( contador < vector.length ){
                if ( ( vector[contador]> numgran[0] ) && ( vector[contador]> numgran[1] )){
                    if ( numgran[0] < numgran[1] ){
                        numgran[0] = vector[contador];
                    }else{
                        numgran[1] = vector[contador];
                    }
                }else if ( vector[contador]> numgran[0] ){
                    numgran[0] = vector[contador];
                }else if ( vector[contador]> numgran[1] ){
                    numgran[1] = vector[contador];
                }else{
                }
                NumMasGrandes(vector, numgran, contador+1);
        }
    }
	
	public static void main(String[] args) {
		int vector[] = { 10, 4, 6, 4, 2, 5, 8, 9 };
        int numgran[] = new int[2];
        numgran[0] = -1;
        numgran[1] = -1;
        NumMasGrandes(vector, numgran, 0);
        System.out.println("Los dos valores mayores son "+numgran[0]+" y "+numgran[1]+".");

	}
}
