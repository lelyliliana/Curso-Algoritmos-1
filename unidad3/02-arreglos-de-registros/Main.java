public class Main {
    public static void main(String[] args) {
        Articulo[] catalogo = new Articulo[3];
        catalogo[0] = new Articulo("K01", "Sensores");
        catalogo[1] = new Articulo("K02", "Cables");
        int cantidad = 2;
        int encontrado = -1;
        for (int i = 0; i < cantidad; i++) {
            if (catalogo[i].codigo().equals("K02")) { encontrado = i; break; }
        }
        System.out.println("Posición K02: " + encontrado);
        int eliminar = 0;
        for (int i = eliminar; i < cantidad - 1; i++) catalogo[i] = catalogo[i + 1];
        catalogo[--cantidad] = null;
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Primero: " + catalogo[0].codigo());
        System.out.println("Capacidad: " + catalogo.length);
    }
}
record Articulo(String codigo, String nombre) {}
