import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int disponibles = 10;
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Unidades vendidas (0..10):");
            if (!teclado.hasNextLine()) return;
            int vendidas = Integer.parseInt(teclado.nextLine().strip());
            if (vendidas < 0 || vendidas > disponibles) {
                System.out.println("Venta fuera de rango");
                return;
            }
            disponibles = disponibles - vendidas;
            System.out.println("Disponibles: " + disponibles);
        } catch (NumberFormatException e) {
            System.out.println("Escribe un número entero");
        }
    }
}
