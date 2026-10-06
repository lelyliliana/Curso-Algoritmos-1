public class Main {
    public static void main(String[] args) {
        int cantidadCajas = 4;
        final int CUADERNOS_POR_CAJA = 12;
        long total = (long) cantidadCajas * CUADERNOS_POR_CAJA;
        System.out.println("Cuadernos: " + total);
        cantidadCajas = 5;
        System.out.println("Cajas actualizadas: " + cantidadCajas);
        System.out.println("Total calculado antes: " + total);
    }
}
