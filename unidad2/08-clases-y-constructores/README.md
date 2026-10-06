# U2_08 · Clases, atributos y constructores

[Anterior](../../unidad2/07-parametros-y-alcance/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/09-instancias-y-responsabilidades/README.md)

## Objetivo

Crear objetos válidos que reúnan estado y operaciones del dominio.

Tema: **Introducción a la programación orientada a objetos**.

## Problema y contrato

Un recipiente tiene una capacidad fija y un contenido que cambia al agregar unidades. El constructor establecerá un estado inicial válido y el método impediría exceder la capacidad.

## Conceptos necesarios

Una clase describe atributos y métodos; un objeto es una instancia concreta. El constructor se ejecuta con new, tiene el nombre de la clase y no declara retorno. This distingue atributos del objeto actual y parámetros que tienen el mismo nombre.

Private impide cambios directos desde otras clases. Encapsular no significa generar getters y setters para todo: significa ofrecer operaciones que mantengan invariantes. En este caso 0 <= contenido <= capacidad y capacidad debe ser positiva.

Capacidad es final porque no cambia durante la vida de este objeto. Agregar devuelve false si la solicitud no cabe; una cantidad no positiva viola el contrato y lanza una excepción. Diferenciamos una falta normal de espacio de una llamada inválida.

Comparamos cantidad con capacidad - contenido antes de sumar. Eso evita hacer primero una suma que pudiera desbordar int. El estado solo cambia después de comprobar.

## Diseño en pseudocódigo

La notación expresa la solución y no se ejecuta directamente como Java o PSeInt. Consulta las [convenciones del curso](../../docs/pseudocodigo-y-pruebas.md).

```text
Construir recipiente con capacidad positiva
contenido ← 0
Al agregar cantidad
  validar cantidad > 0
  Si cantidad > capacidad - contenido: Retornar falso
  contenido ← contenido + cantidad
  Retornar verdadero
```

Relaciona cada paso con una entrada, una validación, un cambio de estado o una salida. Predice el resultado antes de ejecutar.

## Implementación completa

Archivo [Main.java](Main.java). Las clases de apoyo del ejemplo están en el mismo archivo para que puedas ejecutarlo sin dependencias externas. Cada carpeta es independiente; no combines todos los Main como una misma aplicación.

```java
public class Main {
    public static void main(String[] args) {
        Recipiente recipiente = new Recipiente(10);
        System.out.println("Agrega 7: " + recipiente.agregar(7));
        System.out.println("Agrega 5: " + recipiente.agregar(5));
        System.out.println("Contenido: " + recipiente.contenido());
    }
}
class Recipiente {
    private final int capacidad;
    private int contenido;
    Recipiente(int capacidad) {
        if (capacidad <= 0) throw new IllegalArgumentException("Capacidad inválida");
        this.capacidad = capacidad;
    }
    boolean agregar(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad inválida");
        if (cantidad > capacidad - contenido) return false;
        contenido += cantidad;
        return true;
    }
    int contenido() { return contenido; }
}
```

## Ejecutar paso a paso

1. Prepara JDK 21 según tu sistema en la [guía de ambiente](../../docs/ambiente-y-herramientas.md). Si todavía no descargaste el curso, consulta [cómo estudiar en GitHub](../../docs/como-estudiar-en-github.md).
2. Abre PowerShell en Windows o Terminal en Ubuntu/macOS en la raíz del repositorio.
3. Entra a esta carpeta:

```bash
cd unidad2/08-clases-y-constructores
```

4. Ejecuta el archivo:

```bash
java Main.java
```

5. Compara el resultado con el esperado. Para repetir después de modificar, guarda el fuente y vuelve a ejecutar desde la misma carpeta.

Los comandos de Java son los mismos en los tres sistemas. Si compilas por separado, usa las instrucciones de la guía. No necesitas Maven, servidores ni una base de datos.

## Resultado esperado

```text
Agrega 7: true
Agrega 5: false
Contenido: 7
```

## Prueba de escritorio y recorrido

El constructor deja contenido en cero. Agregar 7 cabe y actualiza. Agregar 5 supera las tres unidades libres y devuelve false sin modificar contenido.

Escribe una tabla con instrucción, valor anterior y valor nuevo de las variables que cambian. Para arreglos o matrices, anota también el índice y la celda visitada. La tabla debe explicar cómo se obtiene la salida, no solo repetirla.

## Errores frecuentes

Un método `void Recipiente(...)` no es constructor. Atributos públicos permiten saltarse el control. Actualizar antes de comprobar puede dejar el objeto inválido aunque informes rechazo.

## Práctica

Agrega exactamente 3 después de la primera operación. Intenta otra unidad y comprueba estado. Prueba capacidad cero en un escenario separado.

Antes de ejecutar, registra entrada, resultado esperado y razón. Después agrega resultado observado. Si hay diferencia, localiza la primera instrucción cuyo estado se aparta de tu predicción. Cambia una regla a la vez para identificar su efecto.

<details>
<summary>Orientación de solución (consulta después de intentarlo)</summary>

3 completa la capacidad en 10. La siguiente unidad se rechaza y contenido conserva 10. Capacidad cero se rechaza al construir.

</details>

## Explica con tus palabras

¿Qué protege la clase? ¿Por qué no se ofrece un setter de contenido?

## Evidencia de aprendizaje

Conserva tu código modificado, una tabla de casos y una explicación de la decisión aplicada. Incluye un caso habitual, una frontera y un rechazo cuando el contrato lo permita. Debes poder justificar tanto el resultado como los límites de la solución.

[Anterior](../../unidad2/07-parametros-y-alcance/README.md) · [Índice de la unidad](../README.md) · [Inicio](../../README.md) · [Siguiente recurso](../../unidad2/09-instancias-y-responsabilidades/README.md)
