import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
public class Main {
    public static void main(String[] args) throws IOException {
        String texto = "José";
        byte[] bytes = texto.getBytes(StandardCharsets.UTF_8);
        Path archivo = Path.of("salida", "nombre.txt");
        Files.createDirectories(archivo.getParent());
        Files.write(archivo, bytes);
        System.out.println("Unidades UTF-16: " + texto.length());
        System.out.println("Bytes UTF-8: " + bytes.length);
        System.out.println("Recuperado: " + Files.readString(archivo, StandardCharsets.UTF_8));
    }
}
