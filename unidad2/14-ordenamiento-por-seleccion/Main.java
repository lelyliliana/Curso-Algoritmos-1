import java.util.Arrays;
public class Main {
    static void ordenar(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j] < datos[minimo]) minimo = j;
            }
            int temporal = datos[i];
            datos[i] = datos[minimo];
            datos[minimo] = temporal;
        }
    }
    public static void main(String[] args) {
        int[] datos = {7, 2, 5, 1};
        ordenar(datos);
        System.out.println(Arrays.toString(datos));
    }
}
