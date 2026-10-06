import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        Path archivo = Path.of("salida", "articulos.txt");
        Files.createDirectories(archivo.getParent());
        Files.write(archivo, List.of("codigo;unidades", "K01;3", "K02;0", "K03;dos", "K04;-1"), StandardCharsets.UTF_8);
        List<String> lineas = Files.readAllLines(archivo, StandardCharsets.UTF_8);
        if (lineas.isEmpty() || !lineas.get(0).equals("codigo;unidades")) throw new IllegalArgumentException("Encabezado inválido");
        for (int i = 1; i < lineas.size(); i++) {
            try {
                String[] campos = lineas.get(i).split(";", -1);
                if (campos.length != 2 || campos[0].isBlank()) throw new IllegalArgumentException("Campos inválidos");
                int unidades = Integer.parseInt(campos[1]);
                if (unidades < 0) throw new IllegalArgumentException("Unidades negativas");
                if (unidades > 0) System.out.println(campos[0] + ": " + unidades);
            } catch (IllegalArgumentException e) {
                System.out.println("Línea " + (i + 1) + ": inválida");
            }
        }
    }
}
