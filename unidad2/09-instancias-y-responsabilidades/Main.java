public class Main {
    public static void main(String[] args) {
        Contador salaA = new Contador();
        Contador salaB = new Contador();
        salaA.registrar();
        salaA.registrar();
        salaB.registrar();
        Contador alias = salaA;
        alias.registrar();
        System.out.println("Sala A: " + salaA.cantidad());
        System.out.println("Sala B: " + salaB.cantidad());
    }
}
class Contador {
    private int cantidad;
    void registrar() { cantidad = Math.incrementExact(cantidad); }
    int cantidad() { return cantidad; }
}
