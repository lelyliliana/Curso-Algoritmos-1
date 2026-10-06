public class Main {
    public static void main(String[] args) {
        boolean inscrita = true;
        boolean autorizada = false;
        System.out.println("Permitido: " + (inscrita && autorizada));
        System.out.println("OR: " + (inscrita || autorizada));
        System.out.println("Rechazado: " + !(inscrita && autorizada));
        System.out.println("De Morgan: " + (!inscrita || !autorizada));
        String nombre = null;
        System.out.println("Nombre válido: " + (nombre != null && !nombre.isBlank()));
    }
}
