public class Main {
    public static void main(String[] args) {
        int cuadernos = 17;
        int equipos = 5;
        if (cuadernos < 0 || equipos <= 0) {
            System.out.println("Datos de reparto inválidos");
            return;
        }
        System.out.println("Por equipo: " + cuadernos / equipos);
        System.out.println("Sobrantes: " + cuadernos % equipos);
    }
}
