public class somaRecursiva1 {

    private static int contador = 0;

    public static long somaR(long T) {

        contador++;
        if (T <= 2) {
            return 1;
        } else {
            return somaRecursiva1.somaR(T - 1) + somaRecursiva1.somaR(T - 2);
        }
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        int ini = 0;
        int fim = a.length - 1;
        long resultado = 0;

        if (ini > fim) {
            System.out.println("0");
        }

        if (ini == fim) {
            System.out.println(a[ini] + a[fim]);
        }

        System.out.println(a[ini]);

    resultado = somaRecursiva1.somaR(resultado);
    }

}