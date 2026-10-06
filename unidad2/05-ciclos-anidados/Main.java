import java.util.Locale;
public class Main {
    public static void main(String[] args) {
        for (int radio = 1; radio <= 2; radio++) {
            double area = Math.PI * radio * radio;
            for (int altura = 3; altura <= 4; altura++) {
                double volumen = area * altura;
                System.out.printf(Locale.ROOT, "r=%d h=%d V=%.2f cm3%n", radio, altura, volumen);
            }
        }
    }
}
