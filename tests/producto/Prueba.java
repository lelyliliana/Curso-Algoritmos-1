import java.util.Arrays;
public class Prueba {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] identidad = {{1, 0}, {0, 1}};
        if (!Arrays.deepEquals(Main.multiplicar(a, identidad), new long[][]{{1, 2}, {3, 4}})) throw new AssertionError("Identidad");
        if (!Arrays.deepEquals(Main.multiplicar(new int[][]{{2, 3}}, new int[][]{{4}, {5}}), new long[][]{{23}})) throw new AssertionError("Rectangular");
        try { Main.multiplicar(new int[][]{{1, 2}}, new int[][]{{3, 4}}); throw new AssertionError("Incompatible aceptada"); }
        catch (IllegalArgumentException esperado) { }
        try { Main.multiplicar(new int[][]{{1, 2}, {3}}, identidad); throw new AssertionError("Irregular aceptada"); }
        catch (IllegalArgumentException esperado) { }
        System.out.println("Producto: 4 casos aprobados");
    }
}
