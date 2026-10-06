import java.util.Arrays;
public class Main {
    static void intercambiar(int[] datos, int i, int j) {
        int temporal = datos[i];
        datos[i] = datos[j];
        datos[j] = temporal;
    }
    public static void main(String[] args) {
        int[] datos = {1, 2, 3, 4, 5};
        for (int i = 0, j = datos.length - 1; i < j; i++, j--) {
            intercambiar(datos, i, j);
        }
        System.out.println(Arrays.toString(datos));
    }
}
