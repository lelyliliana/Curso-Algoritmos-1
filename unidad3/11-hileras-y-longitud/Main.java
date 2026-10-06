public class Main {
    public static void main(String[] args) {
        String nombre = "Algoritmos";
        String parte = nombre.substring(0, 4);
        System.out.println("Parte: " + parte);
        System.out.println("Original: " + nombre);
        String texto = "A😀";
        System.out.println("Unidades UTF-16: " + texto.length());
        System.out.println("Puntos de código: " + texto.codePointCount(0, texto.length()));
        System.out.println("Igual contenido: " + nombre.equals(new String("Algoritmos")));
        System.out.println("Concatenación: " + parte.concat(" paso a paso"));
    }
}
