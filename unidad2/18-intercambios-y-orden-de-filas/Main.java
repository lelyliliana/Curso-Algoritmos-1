import java.util.Arrays;
public class Main {
    static void columnas(int[][] datos, int a, int b) {
        for (int[] fila : datos) {
            int temporal = fila[a]; fila[a] = fila[b]; fila[b] = temporal;
        }
    }
    static void filas(int[][] datos, int a, int b) {
        int[] temporal = datos[a]; datos[a] = datos[b]; datos[b] = temporal;
    }
    public static void main(String[] args) {
        int[][] datos = {{30, 5}, {10, 8}, {20, 2}};
        filas(datos, 0, 2);
        columnas(datos, 0, 1);
        columnas(datos, 0, 1);
        for (int i = 0; i < datos.length - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j][0] < datos[minimo][0]) minimo = j;
            }
            filas(datos, i, minimo);
        }
        for (int[] fila : datos) System.out.println(Arrays.toString(fila));
    }
}
