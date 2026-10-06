public class Main {
    public static void main(String[] args) {
        int turno = 1;
        while (turno <= 3) {
            System.out.println("Turno: " + turno);
            turno++;
        }
        int intentos = 0;
        do {
            intentos++;
        } while (intentos < 1);
        System.out.println("Intentos: " + intentos);
        int contador = 5;
        while (contador < 3) contador++;
        System.out.println("While no entró: " + contador);
    }
}
