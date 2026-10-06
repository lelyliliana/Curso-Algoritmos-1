public class Main {
    static int contar(String texto, String patron) {
        if (patron.isEmpty()) throw new IllegalArgumentException("Patrón vacío");
        int cantidad = 0, desde = 0, posicion;
        while ((posicion = texto.indexOf(patron, desde)) != -1) {
            cantidad++;
            desde = posicion + patron.length();
        }
        return cantidad;
    }
    public static void main(String[] args) {
        String texto = "sol y sol";
        System.out.println("Primera posición: " + texto.indexOf("sol"));
        System.out.println("Cantidad: " + contar(texto, "sol"));
        System.out.println("Ausente: " + texto.indexOf("luna"));
        System.out.println("Reemplazo: " + texto.replace("sol", "luz"));
        System.out.println("Original: " + texto);
    }
}
