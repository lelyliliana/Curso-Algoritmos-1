public class Main {
    static double area(double ancho, double alto) {
        if (!Double.isFinite(ancho) || !Double.isFinite(alto) || ancho <= 0 || alto <= 0) {
            throw new IllegalArgumentException("Medidas inválidas");
        }
        return ancho * alto;
    }
    static void mostrar(double valor) {
        System.out.println("Área: " + valor);
    }
    public static void main(String[] args) {
        mostrar(area(3, 4));
        double total = area(3, 4) + area(2, 5);
        System.out.println("Total: " + total);
    }
}
