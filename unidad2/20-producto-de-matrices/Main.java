import java.util.Arrays;
public class Main {
    static int columnas(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            throw new IllegalArgumentException("Matriz vacía");
        }
        int c = m[0].length;
        for (int[] fila : m) {
            if (fila == null || fila.length != c) throw new IllegalArgumentException("Matriz irregular");
        }
        return c;
    }
    static long[][] multiplicar(int[][] a, int[][] b) {
        int k = columnas(a), c = columnas(b);
        if (k != b.length) throw new IllegalArgumentException("Dimensiones incompatibles");
        long[][] resultado = new long[a.length][c];
        for (int f = 0; f < a.length; f++) {
            for (int columna = 0; columna < c; columna++) {
                long suma = 0;
                for (int i = 0; i < k; i++) {
                    suma = Math.addExact(suma, (long) a[f][i] * b[i][columna]);
                }
                resultado[f][columna] = suma;
            }
        }
        return resultado;
    }
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{7, 8}, {9, 10}, {11, 12}};
        for (long[] fila : multiplicar(a, b)) System.out.println(Arrays.toString(fila));
    }
}
