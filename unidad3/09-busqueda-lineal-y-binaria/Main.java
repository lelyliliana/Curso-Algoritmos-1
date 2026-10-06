public class Main {
    static Resultado lineal(int[] datos, int objetivo) {
        int visitas = 0;
        for (int i = 0; i < datos.length; i++) {
            visitas++;
            if (datos[i] == objetivo) return new Resultado(i, visitas);
        }
        return new Resultado(-1, visitas);
    }
    static Resultado binaria(int[] datos, int objetivo) {
        int izquierda = 0, derecha = datos.length - 1, visitas = 0;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            visitas++;
            if (datos[medio] == objetivo) return new Resultado(medio, visitas);
            if (datos[medio] < objetivo) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return new Resultado(-1, visitas);
    }
    public static void main(String[] args) {
        int[] datos = {2, 4, 6, 8, 10, 12, 14};
        Resultado a = lineal(datos, 14), b = binaria(datos, 14);
        System.out.println("Lineal: posición " + a.posicion() + ", visitas " + a.visitas());
        System.out.println("Binaria: posición " + b.posicion() + ", visitas " + b.visitas());
    }
}
record Resultado(int posicion, int visitas) {}
