public class soma {

    private static int contador1 = 0;
    private static int contador2 = 0;
    private static int contN1 = 0;
    private static int contN2 = 0;

    public static int somaA(int[] a, int ini, int fim) {

        contador1++;

        if (ini > fim)
            return 0; // caso base n = 0
        if (ini == fim)
            return a[ini]; // caso base n = 1

        // caso geral
        contN1++;

        return a[ini] + somaA(a, ini + 1, fim - 1) + a[fim];
    }

    public static int somaB(int[] a, int ini, int fim) {

        contador2++;

        if (ini == fim)
            return a[ini]; // caso base n = 1
        if (ini + 1 == fim)
            return a[ini] + a[fim]; // caso base n = 2

        // caso geral
        int med = (ini + fim) / 2;

        contN2++;

        return somaB(a, ini, med) + somaB(a, med + 1, fim);
    }

    public static void main(String[] args) {

        int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println("soma (somaA):\t" + somaA(a, 0, a.length - 1) + " chamadas (somaA):\t" + (contador1)
                + " niveis (somaA):\t" + (contN1));

        System.out.println("soma (somaB):\t" + somaB(a, 0, a.length - 1) + " chamadas (somaB):\t" + (contador2)
                + " niveis (somaB):\t" + (contN2));

    }
}