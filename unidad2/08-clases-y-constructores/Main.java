public class Main {
    public static void main(String[] args) {
        Recipiente recipiente = new Recipiente(10);
        System.out.println("Agrega 7: " + recipiente.agregar(7));
        System.out.println("Agrega 5: " + recipiente.agregar(5));
        System.out.println("Contenido: " + recipiente.contenido());
    }
}
class Recipiente {
    private final int capacidad;
    private int contenido;
    Recipiente(int capacidad) {
        if (capacidad <= 0) throw new IllegalArgumentException("Capacidad inválida");
        this.capacidad = capacidad;
    }
    boolean agregar(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad inválida");
        if (cantidad > capacidad - contenido) return false;
        contenido += cantidad;
        return true;
    }
    int contenido() { return contenido; }
}
