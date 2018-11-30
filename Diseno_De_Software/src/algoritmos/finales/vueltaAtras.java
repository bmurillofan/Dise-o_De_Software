package algoritmos.finales;
import java.util.*;

public class vueltaAtras {
	
	// Tableros Probados
    private static final HashSet<Long> tablerosCheckeados = new HashSet<Long>(); 
    // Tablero solución onrdenados por mejor solución
    private static final ArrayList<Long> tablerosSolucion = new ArrayList<Long>();
 
    
    // Configuración Final verificable, cuando solo hay 1 bola en el centro! 
    private static final long bolaEnCentro = 16777216L;
    // Configuración Inicial, donde hay un espacio libre en el centro!
    private static final long espacioLibreCentro = 124141717933596L;
    // Configuración correcta, ya sea vola en centro o espacio libre en centro!
    private static final long validadorTablero = 124141734710812L;
 
    // Movimientos posibles
    private static final long[][] movimientos = new long[76][];
    
    // Numero de pasos
    private static int pasos = 1;
 
    // Dibujar tablero por cada movimiento
    private static void dibujaTablero(long tablero) {
    	System.out.println("Paso #" + pasos);
        for (int i = 0; i < 49; i++) {
        	
            boolean espacioLibre = ((1L << i) & validadorTablero) != 0L;
            System.out.print(espacioLibre ? (((1L << i) & tablero) != 0L ? "X " : "O ") : "  ");
            if (i % 7 == 6) System.out.println();
        }
        pasos++;
        System.out.println("-------------");
    }
 
    // Movimientos posibles
    private static void createmovimientos(int bit1, int bit2, int bit3, ArrayList<long[]> movimientos) {
        movimientos.add(new long[]{(1L << bit1), (1L << bit2) | (1L << bit3), (1L << bit1) | (1L << bit2) | (1L << bit3)});
        movimientos.add(new long[]{(1L << bit3), (1L << bit2) | (1L << bit1), (1L << bit1) | (1L << bit2) | (1L << bit3)});
    }
 
    
    // Mejor opción de las encontradas
    private static boolean buscador(long tablero) {
        for (long[] move : movimientos) {
            if ((move[1] & tablero) == 0L && (move[0] & tablero) != 0L) {
                long newtablero = tablero ^ move[2];
                if (!tablerosCheckeados.contains(newtablero)) {
                    tablerosCheckeados.add(newtablero);
                    if (newtablero == espacioLibreCentro || buscador(newtablero)) {
                        tablerosSolucion.add(tablero);
                        return true;
                    }
                }
            }
        }
        return false;
    }
 
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        tablerosSolucion.add(espacioLibreCentro);
 
        ArrayList<long[]> movimientos = new ArrayList<long[]>();
        int[] starts = new int[] {2,9,14,15,16,17,18,21,22,23,24,25,28,29,30,31,32,37,44};
        for (int start : starts) {
            createmovimientos(start, start + 1, start + 2, movimientos);
            createmovimientos((start%7) * 7 + start/7, (start%7 + 1) * 7 + start/7, (start%7 + 2) * 7 + start/7, movimientos);
        }
        Collections.shuffle(movimientos);
        movimientos.toArray(vueltaAtras.movimientos);
 
        buscador(bolaEnCentro);
 
        for (long step : tablerosSolucion)
            dibujaTablero(step);
        System.out.println("La mejor solución se da en: "+ pasos + " pasos, con un tiempo: " + (System.currentTimeMillis() - time) + " ms.");
    }
}