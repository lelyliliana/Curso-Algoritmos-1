# Cómo estudiar este curso en GitHub

[Inicio](../README.md) · [Comenzar](../unidad1/01-problemas-y-algoritmos/README.md)

## Leer sin instalar nada

1. Abre el README principal del repositorio.
2. Presiona el enlace de la primera lección o el índice de una unidad.
3. Lee la situación y predice el resultado antes de mirar la salida.
4. Al terminar, presiona **Siguiente recurso**. No necesitas regresar al listado de archivos.

GitHub muestra archivos, carpetas y documentación en la misma página. El README de una carpeta es su explicación. `Main.java` es el fuente ejecutable y `esperado.txt` contiene la salida original. Leer no requiere cuenta de GitHub. Para ejecutar localmente debes descargar los archivos y preparar el JDK.

## Descargar sin usar Git

1. Entra a la página principal del repositorio desde un computador.
2. Abre el botón **Code** y selecciona **Download ZIP**.
3. Extrae el ZIP. No ejecutes dentro del archivo comprimido.
4. Abre la carpeta extraída en el editor o en la terminal.
5. Entra a la carpeta de una lección y sigue sus comandos.

La carpeta extraída puede llamarse `Curso-Algoritmos-1-main`. No es un error: es el nombre de la descarga de la rama principal.

## Descargar con Git

Ejecuta desde la carpeta donde conservas tus proyectos:

```bash
git clone https://github.com/lelyliliana/Curso-Algoritmos-1.git
```

Después entra a `Curso-Algoritmos-1`. Si descargaste ZIP, no tiene el mismo historial local que un clon. Puedes estudiar igualmente, pero no podrás consultar el historial local del repositorio como en un clon.

## Conservar tus ejercicios

Copia el ejemplo a una carpeta de trabajo antes de modificarlo o utiliza una rama propia. Registra qué cambiaste y por qué. Actualizar el material con `git pull` sobre cambios locales exige revisar posibles conflictos; conserva tus prácticas antes de actualizar.

No hace falta saber publicar en GitHub para comenzar. Puedes registrar tus soluciones con Git para conservar cambios y explicar su evolución.
