public class Main {
    public static void main(String[] args) {
        int[] asistentes = {12, 8, 10};
        for (int i = 0; i < asistentes.length; i++) {
            System.out.println("Aula " + (i + 1) + ": " + asistentes[i]);
        }
        System.out.println("Cantidad de datos: " + asistentes.length);
    }
}
