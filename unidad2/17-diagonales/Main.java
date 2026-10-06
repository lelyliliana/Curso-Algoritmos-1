public class Main {
    public static void main(String[] args) {
        int[][] datos = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = datos.length;
        for (int[] fila : datos) {
            if (fila == null || fila.length != n) throw new IllegalArgumentException("Debe ser cuadrada");
        }
        long principal = 0, secundaria = 0;
        for (int i = 0; i < n; i++) {
            principal += datos[i][i];
            secundaria += datos[i][n - 1 - i];
        }
        System.out.println("Principal: " + principal);
        System.out.println("Secundaria: " + secundaria);
        long union = principal + secundaria;
        if (n % 2 == 1) union -= datos[n / 2][n / 2];
        System.out.println("Unión: " + union);
    }
}
