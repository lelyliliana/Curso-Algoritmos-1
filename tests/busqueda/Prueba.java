public class Prueba {
    public static void main(String[] args) {
        int[][] casos = {{}, {1}, {-5, -2, 0, 3, 3, 7}, {2, 4, 6, 8}};
        int verificados = 0;
        for (int[] datos : casos) {
            for (int objetivo = -6; objetivo <= 9; objetivo++) {
                int esperado = Main.lineal(datos, objetivo).posicion();
                int obtenido = Main.binaria(datos, objetivo).posicion();
                if ((esperado == -1) != (obtenido == -1)) throw new AssertionError("Ausencia incoherente");
                if (obtenido != -1 && datos[obtenido] != objetivo) throw new AssertionError("Índice incorrecto");
                verificados++;
            }
        }
        System.out.println("Búsqueda: " + verificados + " casos aprobados");
    }
}
