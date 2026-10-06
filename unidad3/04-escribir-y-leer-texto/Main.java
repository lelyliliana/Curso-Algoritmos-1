import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        Path archivo = Path.of("salida", "nombres.txt");
        Files.createDirectories(archivo.getParent());
        Files.write(archivo, List.of("Ana", "José"), StandardCharsets.UTF_8);
        int cantidad = 0;
        try (BufferedReader lector = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                cantidad++;
                System.out.println(linea);
            }
        }
        System.out.println("Líneas: " + cantidad);
    }
}
