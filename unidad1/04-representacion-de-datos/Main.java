import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        System.out.println("10 en binario: " + Integer.toBinaryString(10));
        System.out.println("Máximo int: " + Integer.MAX_VALUE);
        System.out.println("Aproximado: " + (0.1 + 0.2));
        BigDecimal suma = new BigDecimal("0.1").add(new BigDecimal("0.2"));
        System.out.println("Exacto: " + suma);
        try {
            Math.addExact(Integer.MAX_VALUE, 1);
        } catch (ArithmeticException e) {
            System.out.println("Desbordamiento detectado");
        }
    }
}
