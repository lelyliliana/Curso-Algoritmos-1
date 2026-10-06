public class Main {
    static long sumar(int[] datos) {
        long suma = 0;
        for (int dato : datos) suma += dato;
        return suma;
    }
    public static void main(String[] args) {
        int[] datos = new int[1000];
        for (int i = 0; i < datos.length; i++) datos[i] = i;
        long calentamiento = 0;
        for (int i = 0; i < 100; i++) calentamiento += sumar(datos);
        long inicio = System.nanoTime();
        long checksum = 0;
        for (int i = 0; i < 100; i++) checksum += sumar(datos);
        long duracion = System.nanoTime() - inicio;
        System.out.println("Checksum: " + checksum);
        System.out.println("Coincide con calentamiento: " + (checksum == calentamiento));
        if (args.length > 0 && args[0].equals("--medir")) {
            System.out.println("Intervalo observado (ns): " + duracion);
        }
    }
}
