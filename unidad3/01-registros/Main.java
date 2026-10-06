public class Main {
    public static void main(String[] args) {
        Articulo articulo = new Articulo("K01", "Kit de sensores", 3);
        System.out.println(articulo.codigo() + " / " + articulo.nombre());
        System.out.println("Existencias: " + articulo.existencias());
        System.out.println("Valores iguales: " + articulo.equals(new Articulo("K01", "Kit de sensores", 3)));
    }
}
record Articulo(String codigo, String nombre, int existencias) {
    Articulo {
        if (codigo == null || codigo.isBlank() || nombre == null || nombre.isBlank() || existencias < 0) {
            throw new IllegalArgumentException("Artículo inválido");
        }
        codigo = codigo.strip();
        nombre = nombre.strip();
    }
}
