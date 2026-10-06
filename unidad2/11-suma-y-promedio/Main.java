public class Main {
    public static void main(String[] args) {
        int[] consumos = {12, 8, 11};
        if (consumos.length == 0) {
            System.out.println("Sin mediciones");
            return;
        }
        long suma = 0;
        for (int consumo : consumos) suma += consumo;
        double media = (double) suma / consumos.length;
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + media);
    }
}
