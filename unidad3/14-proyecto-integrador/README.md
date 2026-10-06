# U3_14 · Proyecto integrador: catálogo de materiales

[Anterior](../../unidad3/13-posicion-y-busqueda-de-texto/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../docs/cierre.md)

## Objetivo

Integrar registros, arreglos, búsquedas, operaciones de texto y persistencia validada.

Tema: **Integración de las tres unidades**.

## Problema y contrato

Un centro comunitario conserva materiales por código. Necesita dar de alta, buscar, eliminar, listar y guardar el catálogo. Una carga inválida debe dejar intactos los datos que ya estaban en memoria.

## Conceptos necesarios

## Contrato de la aplicación

| Aspecto | Regla |
|---|---|
| Identidad | Código único, distingue mayúsculas |
| Campos | Código y nombre no vacíos, sin `;` ni saltos de línea |
| Unidades | Entero no negativo |
| Capacidad | Entre1 y10000 registros; cantidad no supera capacidad |
| Búsqueda | Lineal por código; filtro de nombre insensible a mayúsculas |
| Borrado | Desplaza registros y devuelve false si el código no existe |
| Archivo | UTF-8, capacidad y encabezado explícitos |
| Carga | Rechaza cualquier fila inválida o código duplicado |
| Fallo de carga | Conserva el catálogo en memoria |

Articulo es un record de datos validados. Catalogo encapsula un arreglo y su cantidad lógica. Main coordina los modos y las operaciones de archivo. El código se mantiene en un archivo para ejecución directa; las responsabilidades quedan expresadas en métodos y tipos distintos.

El archivo de muestra usa primera línea `capacidad;N`, segunda `codigo;nombre;unidades` y filas delimitadas. No es CSV general. El guardado sobrescribe `salida/catalogo.txt`; no es escritura atómica ante corte de energía ni permite edición concurrente. La carga construye un candidato y solo lo publica cuando todos los datos pasan las reglas.

## Modos

`java Main.java` ejecuta una demostración reproducible. `java Main.java --interactivo` abre el menú con catálogo vacío de capacidad10. Guarda antes de salir y carga al volver para recuperar los datos. `java Main.java --verificar` comprueba contratos y recuperación en una carpeta temporal que elimina al terminar.

Buscar por código recorre hasta cantidad, O(n). Borrar puede desplazar O(n) registros. Filtrar por nombre depende también de longitudes de texto; no atribuyas costo constante a cada comparación textual. Guardar recorre los registros y sus campos. Cargar también recorre las filas, pero cada alta busca códigos previos: con n registros puede realizar O(n²) comparaciones de códigos. Si las longitudes de texto son variables, incluye también su costo. El arreglo ocupa memoria proporcional a capacidad, aunque haya menos elementos utilizados.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Crear catálogo válido
Agregar registros con código único
Consultar y filtrar datos
Guardar capacidad y registros
Cargar archivo en candidato independiente
Si toda la carga es válida: reemplazar catálogo
Si falla: conservar estado anterior e informar
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
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
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad3/14-proyecto-integrador
```

4. Ejecuta el archivo:

```bash
java Main.java
```

Para abrir el menú usa `java Main.java --interactivo`; para comprobar sus reglas, `java Main.java --verificar`.

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Consulta K01: Sensores
Coincidencias 'cabl': 1
K01: Sensores / 4
K02: Cables / 8
Registros: 2
Catálogo recuperado desde archivo
```

## Prueba de escritorio y recorrido

La demostración agrega dos registros únicos. Buscar recorre la parte ocupada y filtrar encuentra Cables. Guardar completa el archivo. Cargar reconstruye un catálogo distinto con los mismos campos y capacidad.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Recorrer capacidad como si toda posición fuera válida accede a null. Eliminar sin limpiar conserva referencias fuera de la zona usada. Asignar el catálogo antes de validar todas las filas publica un estado parcial. El guardado no garantiza recuperación ante una interrupción de escritura.

## Práctica

Agrega actualización de unidades por código y listado ordenado por nombre. Define la respuesta ante código inexistente. Verifica que el listado no altere la identidad ni el orden interno y que guardar/cargar conserve la actualización.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

Para actualizar, localiza el índice y reemplaza el record por otro validado con mismo código y nombre. Para ordenar el listado, usa snapshot y un Comparator sobre la copia. Comprueba ausencia, unidades negativas, tildes y recuperación. No expongas el arreglo interno.

</details>

## Explica con tus palabras

¿Por qué cantidad no es capacidad? ¿Qué información se valida por fila y cuál sobre todo el catálogo?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad3/13-posicion-y-busqueda-de-texto/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../docs/cierre.md)
