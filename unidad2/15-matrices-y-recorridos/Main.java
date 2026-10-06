import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[][] datos = {{2, 4, 6}, {1, 3, 5}};
        System.out.println("Por filas:");
        for (int[] fila : datos) System.out.println(Arrays.toString(fila));
        System.out.println("Por columnas:");
        for (int c = 0; c < datos[0].length; c++) {
            StringBuilder columna = new StringBuilder();
            for (int f = 0; f < datos.length; f++) {
                if (f > 0) columna.append(" ");
                columna.append(datos[f][c]);
            }
            System.out.println(columna);
        }
    }
}
