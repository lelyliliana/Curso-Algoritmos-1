public class Main {
    public static void main(String[] args) {
        int[] temperaturas = {-8, -3, -12, -3};
        if (temperaturas.length == 0) {
            System.out.println("Sin temperaturas");
            return;
        }
        int menor = temperaturas[0];
        int mayor = temperaturas[0];
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] < menor) menor = temperaturas[i];
            if (temperaturas[i] > mayor) mayor = temperaturas[i];
        }
        System.out.println("Menor: " + menor);
        System.out.println("Mayor: " + mayor);
    }
}
