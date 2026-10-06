public class Main {
    public static void main(String[] args) {
        int edad = 12;
        boolean autorizada = false;
        if (edad < 0) {
            System.out.println("Edad inválida");
        } else if (edad < 12 || edad > 17) {
            System.out.println("Fuera del grupo");
        } else if (autorizada) {
            System.out.println("Puede participar");
        } else {
            System.out.println("Falta autorización");
        }
    }
}
