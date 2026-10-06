public class Main {
    public static void main(String[] args) {
        int total = 0;
        int pares = 0;
        for (int numero = 1; numero <= 6; numero++) {
            total += numero;
            if (numero % 2 == 0) pares++;
        }
        System.out.println("Suma: " + total);
        System.out.println("Pares: " + pares);
    }
}
