// Esqueleto da classe na qual devem ser implementadas as novas funcionalidades de desenho

public class ImageEx extends Image {

	static ImageEx img = null;

	public ImageEx(int w, int h, int r, int g, int b) {
		super(w, h, r, g, b);
	}

	public ImageEx(int w, int h) {
		super(w, h);
	}

	public int calculaReta(int x1, int y1, int x2, int y2) {

		int subtracaoA = x2 - x1; /* coordenadas X */
		int subtracaoB = y2 - y1; /* coordenadas Y */

		return (int) Math.sqrt(Math.pow(subtracaoA, 2) + Math.pow(subtracaoB, 2)); /* formula para o calculo de uma reta */
	}

	public void kochCurve(int px, int py, int qx, int qy, int l) {

		/*
		 * A partir de uma reta PQ já desenhado!
		 * 
		 * double sen60 = Math.sin(3.14 / 3);
		 * 
		 * 
		 * coloca os valores calculados em "calculaReta" px, py, qx e qy em cada
		 * variável de "kochCurve" para o cálculo das distância de cada ponto
		 * 
		 * int resultadoDaReta = calculaReta(px, py, qx, qy);
		 * 
		 * 
		 * calcula os pontos de modo que o comprimento de cada um seja 1/3 do
		 * comprimento PQ
		 * 
		 * int distancia = (int) (resultadoDaReta / 3);
		 * 
		 * desenha a primeira linha
		 * 
		 * if (distancia < l) { img.drawLine(px, py, qx, qy); return; }
		 */

		/*
		 * 1) se c < l então desenhe o segmento de reta PQ 2) Caso contrário: (a)
		 * calcule os pontos A, B, C (b) chame o algoritmo recursivamente para PA, AB,
		 * BC, CQ (px, py, qx, qy)
		 * 
		 * /* ponto A e C, esses pontos fazem parte do segmento PQ
		 */
		/* ponto R qualquer do segmento PQ */

		int resultadoDaReta = calculaReta(px, py, qx, qy);
		int distancia = (int) (resultadoDaReta / 3);

		if (distancia < l) {
			img.drawLine(px, py, qx, qy);
			return;
		}

		/* Calculo das coordenadas do ponto A */

		int a1 = (int) (1 - (1 / 3)) * px + (1 / 3) * qx;
		int a2 = (int) (1 - (1 / 3)) * py + (1 / 3) * qy;

		/* Calculo das coordenadas do ponto B */

		/*
		 * Para o calculo do B, precisamos de algumas etapas a mais. Vamos primeiro
		 * calcular o ponto M que está na metade do segmento e, portanto, pode ser
		 * calculado de modo similar aos pontos A e C, porém usando o valor 0.5. A
		 * partir desse ponto M, podemos calcular B como sendo
		 */

		/*
		 * Calculo do ponto que se encontra na metade do segmento Usando duas
		 * coordenadas
		 */
		int m1 = (int) (1 - (1 / 2)) * px + (1 / 2) * qx;
		int m2 = (int) (1 - (1 / 2)) * py + (1 / 2) * qy;

		/* Calculando o vetor "v" que liga o ponto P ao ponto Q */

		int v1 = (int) (qx - px);
		int v2 = (int) (qy - qx);

		/*
		 * Calculo do comprimento esperado do vetor u, equivalente a altura h do
		 * triangulo formado pelos pontos A, B e C
		 */

		/* o "l" do professor é o meu "distancia" */

		double h = (int) Math.abs(distancia) * Math.sqrt(3) / 6;

		/* Calculo do vetor rv, perpendicular ao vetor v */

		double angulo = (Math.PI / 2) - Math.atan((double) (qy - py) / (qx - px));

		double u1 = (int) angulo * Math.sqrt(3) / 6;

		/* Calculo do ponto B, utilizando o M e o vetor que liga o ponto P ao ponto Q */

		double b1 = (int) m1 + u1;
		double b2 = (int) m2 - u1;

		int bx = (int) b1;
		int by = (int) b2;

		/* Calculo das coordenadas do ponto C */
		int c1 = (int) (1 - (2 / 3)) * px + (2 / 3) * qx;
		int c2 = (int) (1 - (2 / 3)) * py + (2 / 3) * qx;

		/* Usando a recursividade para desenhar a curva de Koch */

		kochCurve(px, py, a1, a2, l);
		kochCurve(a1, a2, bx, by, l);
		kochCurve(bx, by, c1, c2, l);
		kochCurve(c1, c2, qx, qy, l);

	}

	public static void drawKochCurve() {

		int w = 1000;
		int h = 1000;
		ImageEx img = new ImageEx(w, h, 0, 0, 0);
		img.setBgColor(0, 0, 0);
		img.clear();

		img.setColor(255, 195, 0);
		img.kochCurve(500, 750, 500, 250, 10);

		img.save("kochCurve");

	}

	public void regionFill(int x, int y, int reference_rgb) {

	}

	public static void drawRegionFill(String fileName) {

	}

	public static void main(String[] args) {
		drawKochCurve();
	}

}