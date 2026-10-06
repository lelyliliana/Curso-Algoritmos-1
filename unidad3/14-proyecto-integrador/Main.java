import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length > 0 && args[0].equals("--verificar")) verificar();
        else if (args.length > 0 && args[0].equals("--interactivo")) menu();
        else {
            Catalogo catalogo = new Catalogo(3);
            catalogo.agregar(new Articulo("K01", "Sensores", 4));
            catalogo.agregar(new Articulo("K02", "Cables", 8));
            System.out.println("Consulta K01: " + catalogo.buscar("K01").nombre());
            System.out.println("Coincidencias 'cabl': " + catalogo.filtrar("cabl").length);
            Path archivo = Path.of("salida", "catalogo.txt");
            guardar(catalogo, archivo);
            Catalogo recuperado = cargar(archivo);
            mostrar(recuperado);
            System.out.println("Catálogo recuperado desde archivo");
        }
    }
    static void mostrar(Catalogo catalogo) {
        for (Articulo a : catalogo.snapshot()) {
            System.out.println(a.codigo() + ": " + a.nombre() + " / " + a.unidades());
        }
        System.out.println("Registros: " + catalogo.cantidad());
    }
    static void guardar(Catalogo catalogo, Path archivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add("capacidad;" + catalogo.capacidad());
        lineas.add("codigo;nombre;unidades");
        for (Articulo a : catalogo.snapshot()) {
            lineas.add(a.codigo() + ";" + a.nombre() + ";" + a.unidades());
        }
        Files.createDirectories(archivo.toAbsolutePath().getParent());
        Files.write(archivo, lineas, StandardCharsets.UTF_8);
    }
    static Catalogo cargar(Path archivo) throws IOException {
        List<String> lineas = Files.readAllLines(archivo, StandardCharsets.UTF_8);
        if (lineas.size() < 2 || !lineas.get(0).startsWith("capacidad;")
                || !lineas.get(1).equals("codigo;nombre;unidades")) {
            throw new IllegalArgumentException("Encabezados inválidos");
        }
        int capacidad = Integer.parseInt(lineas.get(0).substring("capacidad;".length()));
        Catalogo candidato = new Catalogo(capacidad);
        for (int i = 2; i < lineas.size(); i++) {
            try {
                String[] campos = lineas.get(i).split(";", -1);
                if (campos.length != 3) throw new IllegalArgumentException("Se requieren 3 campos");
                candidato.agregar(new Articulo(campos[0], campos[1], Integer.parseInt(campos[2])));
            } catch (IllegalArgumentException | IllegalStateException e) {
                throw new IllegalArgumentException("Línea " + (i + 1) + ": " + e.getMessage(), e);
            }
        }
        return candidato;
    }
    static String leer(Scanner teclado, String mensaje) {
        System.out.println(mensaje);
        return teclado.hasNextLine() ? teclado.nextLine() : null;
    }
    static void menu() {
        Catalogo catalogo = new Catalogo(10);
        Path archivo = Path.of("salida", "catalogo.txt");
        try (Scanner teclado = new Scanner(System.in)) {
            while (true) {
                String opcion = leer(teclado, "1 Alta / 2 Buscar / 3 Eliminar / 4 Listar / 5 Guardar / 6 Cargar / 0 Salir");
                if (opcion == null || opcion.strip().equals("0")) return;
                try {
                    switch (opcion.strip()) {
                        case "1" -> {
                            String codigo = leer(teclado, "Código:");
                            if (codigo == null) return;
                            String nombre = leer(teclado, "Nombre:");
                            if (nombre == null) return;
                            String unidades = leer(teclado, "Unidades:");
                            if (unidades == null) return;
                            catalogo.agregar(new Articulo(codigo, nombre, Integer.parseInt(unidades.strip())));
                            System.out.println("Alta registrada");
                        }
                        case "2" -> {
                            String codigo = leer(teclado, "Código:");
                            if (codigo == null) return;
                            Articulo a = catalogo.buscar(codigo.strip());
                            System.out.println(a == null ? "No encontrado" : a.nombre() + " / " + a.unidades());
                        }
                        case "3" -> {
                            String codigo = leer(teclado, "Código:");
                            if (codigo == null) return;
                            System.out.println(catalogo.eliminar(codigo.strip()) ? "Eliminado" : "No encontrado");
                        }
                        case "4" -> mostrar(catalogo);
                        case "5" -> { guardar(catalogo, archivo); System.out.println("Guardado completo"); }
                        case "6" -> {
                            Catalogo candidato = cargar(archivo);
                            catalogo = candidato;
                            System.out.println("Carga completa");
                        }
                        default -> System.out.println("Opción desconocida");
                    }
                } catch (IllegalArgumentException | IllegalStateException | IOException e) {
                    System.out.println("No se completó: " + e.getMessage());
                }
            }
        }
    }
    static void comprobar(boolean condicion, String mensaje) {
        if (!condicion) throw new AssertionError(mensaje);
    }
    static void verificar() throws IOException {
        Catalogo c = new Catalogo(2);
        c.agregar(new Articulo("K01", "Sensores", 3));
        try { c.agregar(new Articulo("K01", "Duplicado", 8)); throw new AssertionError("Duplicado aceptado"); }
        catch (IllegalArgumentException esperado) { comprobar(c.cantidad() == 1, "Duplicado cambió cantidad"); }
        c.agregar(new Articulo("K02", "José", 0));
        try { c.agregar(new Articulo("K03", "Cables", 1)); throw new AssertionError("Excedió capacidad"); }
        catch (IllegalStateException esperado) { comprobar(c.cantidad() == 2, "Capacidad alterada"); }
        comprobar(c.buscar("K01").unidades() == 3, "Consulta incorrecta");
        comprobar(c.buscar("K99") == null, "Ausencia incorrecta");
        comprobar(c.filtrar("SENSOR").length == 1, "Filtro incorrecto");
        Articulo[] copia = c.snapshot(); copia[0] = null;
        comprobar(c.buscar("K01") != null, "Snapshot expone arreglo interno");
        for (String nombre : new String[]{"", "A;B", "A\nB"}) {
            try { new Articulo("K10", nombre, 1); throw new AssertionError("Campo inválido aceptado"); }
            catch (IllegalArgumentException esperado) { }
        }
        try { new Articulo("K10", "Cables", -1); throw new AssertionError("Negativo aceptado"); }
        catch (IllegalArgumentException esperado) { }
        Path carpeta = Files.createTempDirectory("catalogo-prueba-");
        Path archivo = carpeta.resolve("datos.txt");
        try {
            guardar(c, archivo);
            Catalogo restaurado = cargar(archivo);
            comprobar(Arrays.equals(c.snapshot(), restaurado.snapshot()), "Recuperación UTF-8");
            comprobar(restaurado.capacidad() == c.capacidad(), "Capacidad no conservada");
            Articulo[] anterior = c.snapshot();
            Files.write(archivo, List.of("capacidad;2", "codigo;nombre;unidades", "K09;Nuevo;1", "K09;Duplicado;2"), StandardCharsets.UTF_8);
            boolean rechazado = false;
            try { Catalogo candidato = cargar(archivo); c = candidato; }
            catch (IllegalArgumentException esperado) { rechazado = true; }
            comprobar(rechazado, "Carga corrupta aceptada");
            comprobar(Arrays.equals(anterior, c.snapshot()), "Publicó carga parcial");
            Files.writeString(archivo, "encabezado incorrecto", StandardCharsets.UTF_8);
            try { cargar(archivo); throw new AssertionError("Encabezado inválido aceptado"); }
            catch (IllegalArgumentException esperado) { }
        } finally {
            Files.deleteIfExists(archivo); Files.deleteIfExists(carpeta);
        }
        comprobar(c.eliminar("K01"), "Borrado rechazado");
        comprobar(c.cantidad() == 1 && c.snapshot()[0].codigo().equals("K02"), "Desplazamiento incorrecto");
        comprobar(!c.eliminar("K99") && c.cantidad() == 1, "Borrado ausente altera estado");
        System.out.println("Verificación de catálogo y persistencia aprobada");
    }
}

record Articulo(String codigo, String nombre, int unidades) {
    Articulo {
        codigo = campo(codigo); nombre = campo(nombre);
        if (unidades < 0) throw new IllegalArgumentException("Unidades negativas");
    }
    static String campo(String texto) {
        if (texto == null || texto.isBlank() || texto.contains(";") || texto.contains("\n") || texto.contains("\r")) {
            throw new IllegalArgumentException("Campo vacío o con separador no permitido");
        }
        return texto.strip();
    }
}

class Catalogo {
    private final Articulo[] datos;
    private int cantidad;
    Catalogo(int capacidad) {
        if (capacidad < 1 || capacidad > 10000) throw new IllegalArgumentException("Capacidad fuera de 1..10000");
        datos = new Articulo[capacidad];
    }
    int capacidad() { return datos.length; }
    int cantidad() { return cantidad; }
    private int posicion(String codigo) {
        for (int i = 0; i < cantidad; i++) if (datos[i].codigo().equals(codigo)) return i;
        return -1;
    }
    Articulo buscar(String codigo) {
        int i = posicion(codigo); return i == -1 ? null : datos[i];
    }
    void agregar(Articulo articulo) {
        if (articulo == null) throw new IllegalArgumentException("Falta artículo");
        if (posicion(articulo.codigo()) != -1) throw new IllegalArgumentException("Código duplicado");
        if (cantidad == datos.length) throw new IllegalStateException("Catálogo lleno");
        datos[cantidad++] = articulo;
    }
    boolean eliminar(String codigo) {
        int i = posicion(codigo);
        if (i == -1) return false;
        for (int j = i; j < cantidad - 1; j++) datos[j] = datos[j + 1];
        datos[--cantidad] = null;
        return true;
    }
    Articulo[] snapshot() { return Arrays.copyOf(datos, cantidad); }
    Articulo[] filtrar(String fragmento) {
        String normalizado = fragmento.toLowerCase(Locale.ROOT);
        List<Articulo> salida = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            if (datos[i].nombre().toLowerCase(Locale.ROOT).contains(normalizado)) salida.add(datos[i]);
        }
        return salida.toArray(Articulo[]::new);
    }
}
