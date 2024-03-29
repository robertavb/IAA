/* Roberta Vitoria Borges nUSP 11344811  - Turma 04 */

public class ImageEx extends Image {

	public ImageEx(int w, int h, int r, int g, int b) {
		super(w, h, r, g, b);
	}

	public ImageEx(int w, int h) {
		super(w, h);
	}

	public int calculaReta(int x1, int y1, int x2, int y2) {

		int subtracaoA = x1 - x2; /* coordenadas X */
		int subtracaoB = y1 - y2; /* coordenadas Y */

		return (int) Math.sqrt(Math.pow(subtracaoA, 2) + Math.pow(subtracaoB, 2)); /* formula para o calculo de uma reta */
	}

	public void kochCurve(int px, int py, int qx, int qy, int l) {

		/* Pontos A, B, C e ponto m1 e m2 */

		int ax, ay, bx, by, cx, cy, m1, m2;

		int resultadoDaReta = calculaReta(px, py, qx, qy);

		/* Tamanho do lado do triangulo */
		int distancia = (int) resultadoDaReta / 3;

		if (distancia < l) {
			drawLine(px, py, qx, qy);
		} else {

			/* Calculo das coordenadas do ponto A */

			ax = (int) (px + ((double) (qx - px) / 3));
			ay = (int) (py + ((double) (qy - py) / 3));

			/* Calculo necessarios para calcular as coordenadas do ponto B */

			/*
			 * Calculo do ponto que se encontra na metade do segmento Usando duas
			 * coordenadas
			 */

			m1 = (int) (((double) (qx + px) / 2));
			m2 = (int) (((double) (qy + py) / 2));

			/*
			 * Calculo do vetor rv, perpendicular ao vetor v Usamos Math.PI/2 para o calculo
			 * do angulo de 90 graus e o Math.atan(y/x) para o angulo que a linha
			 * [(0,0};(x,y)] forma com o eixo x em um sistema de coordenadas cartesianas
			 */

			double angulo = (Math.PI / 2) - Math.atan((double) (qy - py) / (qx - px));

			/*
			 * Calculo com que fará que as linhas rotacionem x graus para formar a curva de
			 * Koch
			 */

			double x = distancia * Math.cos(angulo);
			double y = distancia * Math.sin(angulo);

			/*
			 * Calculo do ponto B, utilizando o M e o vetor u que liga o ponto P ao ponto Q
			 */

			if (px > qx) {
				bx = (int) (m1 - x);
				by = (int) (m2 + y);
			} else {
				bx = (int) (m1 + x);
				by = (int) (m2 - y);
			}

			/* Calculo das coordenadas do ponto C */
			cx = (int) (px + ((double) (qx - px) * 2.0 / 3.0));
			cy = (int) (py + ((double) (qy - py) * 2.0 / 3.0));

			/* Usando a recursividade para desenhar a curva de Koch */
			kochCurve(px, py, ax, ay, l);
			kochCurve(ax, ay, bx, by, l);
			kochCurve(bx, by, cx, cy, l);
			kochCurve(cx, cy, qx, qy, l);
		}
	}

	public void regionFill(int x, int y) {
		regionFill(x, y, getPixel(x, y));
	}

	public void regionFill(int x, int y, int reference_rgb) {

		/* verifica se os valores são válidos */
		if (x < 0 || y < 0 || getWidth() <= x || getHeight() <= y) {
			return;
		}

		/*
		 * Verifica se o valor de cor do pixel é o mesmo da cor original do pixel
		 * inicial
		 */
		if (reference_rgb != getPixel(x, y)) {
			return;
		}

		/* Colore o pixel */
		setPixel(x, y);

		/* Usando a recursividade para colorir a área */
		regionFill(x + 1, y, reference_rgb);
		regionFill(x, y + 1, reference_rgb);
		regionFill(x - 1, y, reference_rgb);
		regionFill(x, y - 1, reference_rgb);

	}
}