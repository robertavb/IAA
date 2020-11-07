public class soma {

    private static int contador1 = 0;
    private static int contador2 = 0;

    public static int somaA(int[] a, int ini, int fim) {

        contador1++;

        if (ini > fim)
            return 0; // caso base n = 0
        if (ini == fim)
            return a[ini]; // caso base n = 1

        // caso geral

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

        return somaB(a, ini, med) + somaB(a, med + 1, fim);
    }

    private class NodeNivel { // classe para ter No e Nivel
        public Node no;
        public int nivel;

        public NodeNivel(Node no, int nivel) {
            this.no = no;
            this.nivel = nivel;
        }
    }

    public int nivel() {
        Node aux = raiz;
        int nivel = 0;
        if (aux == null)
            throw new IllegalArgumentException("Arvore vazia.");
        Deque<NodeNivel> fila = new ArrayDeque<>(); // Agora Deque<NodeNivel>

        // cada vez que empilha leva nivel tambem,que é 1 para a raiz
        fila.add(new NodeNivel(aux, 1));

        while (!fila.isEmpty()) {
            NodeNivel atual = fila.removeFirst(); // Agora NodeNivel

            // estes ifs agora empilham NodeNivel aumentando o nivel em 1
            if (atual.no.getNodeEsquerda() != null)
                fila.add(new NodeNivel(atual.no.getNodeEsquerda(), atual.nivel + 1));
            if (atual.no.getNodeDireita() != null)
                fila.add(new NodeNivel(atual.no.getNodeDireita(), atual.nivel + 1));

            // verifica e atualiza o nivel maximo
            if (atual.nivel > nivel)
                nivel = atual.nivel;
        }

        return nivel;
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5, 6, 7 };

        System.out.println("soma (somaA):\t" + somaA(a, 0, a.length - 1) + " chamadas (somaA):\t" + (contador1));

        System.out.println("soma (somaB):\t" + somaB(a, 0, a.length - 1) + " chamadas (somaB):\t" + (contador2));

    }
}