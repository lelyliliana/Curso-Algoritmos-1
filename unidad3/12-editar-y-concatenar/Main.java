public class Main {
    public static void main(String[] args) {
        StringBuilder titulo = new StringBuilder("Curso Java");
        titulo.insert(6, "de ");
        System.out.println("Insertar: " + titulo);
        titulo.delete(9, 13);
        titulo.append("algoritmos");
        System.out.println("Borrar y agregar: " + titulo);
        titulo.replace(0, 5, "Taller");
        String copia = titulo.toString();
        titulo.append(" 1");
        System.out.println("Versión guardada: " + copia);
        System.out.println("Actual: " + titulo);
    }
}
