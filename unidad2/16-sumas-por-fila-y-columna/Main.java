public class Main {
    public static void main(String[] args) {
        int[][] datos = {{2, 4, 6}, {1, 3, 5}};
        for (int f = 0; f < datos.length; f++) {
            long suma = 0;
            for (int c = 0; c < datos[f].length; c++) suma += datos[f][c];
            System.out.println("Fila " + f + ": " + suma);
        }
        for (int c = 0; c < datos[0].length; c++) {
            long suma = 0;
            for (int f = 0; f < datos.length; f++) suma += datos[f][c];
            System.out.println("Columna " + c + ": " + suma);
        }
    }
}
