import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class Main {
    public static void main(String[] args) throws IOException {
        Path archivo = Path.of("salida", "articulo.bin");
        Files.createDirectories(archivo.getParent());
        try (DataOutputStream out = new DataOutputStream(Files.newOutputStream(archivo))) {
            out.writeInt(1); out.writeUTF("K01"); out.writeInt(3);
        }
        try (DataInputStream in = new DataInputStream(Files.newInputStream(archivo))) {
            if (in.readInt() != 1) throw new IOException("Versión no admitida");
            String codigo = in.readUTF();
            int unidades = in.readInt();
            if (codigo.isBlank() || unidades < 0) throw new IOException("Datos inválidos");
            System.out.println(codigo + ": " + unidades);
        }
    }
}
