public class Main {
    static long total(long compra) {
        if (compra < 0 || compra > 1000000) throw new IllegalArgumentException("Compra fuera de rango");
        long descuento = compra >= 100000 ? compra * 10 / 100 : 0;
        return compra - descuento;
    }
    public static void main(String[] args) {
        long[] compras = {99990, 100000, 100010};
        long[] esperados = {99990, 90000, 90009};
        for (int i = 0; i < compras.length; i++) {
            long obtenido = total(compras[i]);
            if (obtenido != esperados[i]) throw new AssertionError("Caso " + i);
            System.out.println(compras[i] + " -> " + obtenido);
        }
    }
}
