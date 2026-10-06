import java.util.Arrays;
public class Prueba {
    public static void main(String[] args) {
        int[][] casos = {{}, {1}, {3, 1, 3, -2, 0}, {5, 4, 3, 2, 1}, {1, 2, 3}};
        for (int[] original : casos) {
            int[] esperado = original.clone(); Arrays.sort(esperado);
            int[] obtenido = original.clone(); Main.ordenar(obtenido);
            if (!Arrays.equals(esperado, obtenido)) throw new AssertionError("Orden o valores incorrectos");
        }
        System.out.println("Selección: 5 casos aprobados");
    }
}
