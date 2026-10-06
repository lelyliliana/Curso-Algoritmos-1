public class Main {
    public static void main(String[] args) {
        for (int n : new int[]{10, 20, 40}) {
            long lineal = 3L * n + 5;
            long triangular = (long) n * (n - 1) / 2;
            System.out.println("n=" + n + " lineal=" + lineal + " pares=" + triangular);
        }
        int filas = 3, columnas = 7;
        System.out.println("Celdas f*c: " + filas * columnas);
    }
}
