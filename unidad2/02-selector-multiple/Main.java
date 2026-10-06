public class Main {
    public static void main(String[] args) {
        int opcion = 2;
        String servicio = switch (opcion) {
            case 1 -> "Consulta";
            case 2 -> "Préstamo";
            case 3 -> "Devolución";
            default -> "Opción desconocida";
        };
        System.out.println(servicio);
    }
}
