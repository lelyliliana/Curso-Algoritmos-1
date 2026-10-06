public class Main {
    public static void main(String[] args) {
        int n = 4;
        long visitas = 0, pares = 0;
        for (int i = 0; i < n; i++) visitas++;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) pares++;
        }
        System.out.println("Visitas: " + visitas);
        System.out.println("Pares: " + pares);
        System.out.println("Fórmula pares: " + (long) n * (n - 1) / 2);
    }
}
