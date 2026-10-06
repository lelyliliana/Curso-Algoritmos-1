public class Main {
    static void cambiarNumero(int numero) { numero++; }
    static void cambiarArreglo(int[] datos) {
        datos[0]++;
        datos = new int[]{99};
    }
    public static void main(String[] args) {
        int numero = 5;
        int[] datos = {5};
        cambiarNumero(numero);
        cambiarArreglo(datos);
        System.out.println("Número: " + numero);
        System.out.println("Elemento: " + datos[0]);
    }
}
