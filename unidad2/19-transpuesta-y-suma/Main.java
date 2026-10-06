import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{10, 20, 30}, {40, 50, 60}};
        int filas = a.length, columnas = a[0].length;
        int[][] transpuesta = new int[columnas][filas];
        long[][] suma = new long[filas][columnas];
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                transpuesta[c][f] = a[f][c];
                suma[f][c] = (long) a[f][c] + b[f][c];
            }
        }
        System.out.println("Transpuesta:");
        for (int[] fila : transpuesta) System.out.println(Arrays.toString(fila));
        System.out.println("Suma:");
        for (long[] fila : suma) System.out.println(Arrays.toString(fila));
    }
}
