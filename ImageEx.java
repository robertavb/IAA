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

		int resultadoDaReta = calculaReta(px, py, qx, qy);
		int distancia = (int) (resultadoDaReta / 3);

		if (distancia < l) {
			/* fiz py e qy antes de px e py para deixar na horizontal */
			img.drawLine(py, px, qy, qx);
			return;
		}

		/* Calculo das coordenadas do ponto A */

		int a1 = (int) (px + ((double) (qx - px) * 1 / 3));
		int a2 = (int) (py + ((double) (qy - py) * 1 / 3));

		/* Calculo necessarios para calcular as coordenadas do ponto B */

		/*
		 * Calculo do ponto que se encontra na metade do segmento Usando duas
		 * coordenadas
		 */

		int m1 = (int) (px + ((double) (qx - px) / 2));
		int m2 = (int) (py + ((double) (qy - py) / 2));

		/*
		 * Calculo do comprimento esperado do vetor u, equivalente a altura h do
		 * triangulo formado pelos pontos A, B e C
		 */

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

		/* Calculo do ponto B, utilizando o M e o vetor que liga o ponto P ao ponto Q */
		int b1;
		int b2;

		if (px > qx) {
			b1 = (int) (m1 - x);
			b2 = (int) (m2 + y);
		} else {
			b1 = (int) (m1 + x);
			b2 = (int) (m2 - y);
		}

		/* Calculo das coordenadas do ponto C */
		int c1 = (int) (px + ((qx - px) * 2.0 / 3.0));
		int c2 = (int) (py + ((qy - py) * 2.0 / 3.0));

		/* Usando a recursividade para desenhar a curva de Koch */
		kochCurve(px, py, a1, a2, l);
		kochCurve(a1, a2, b1, b2, l);
		kochCurve(b1, b2, c1, c2, l);
		kochCurve(c1, c2, qx, qy, l);

	}

	public static void drawKochCurve() {

		int w = 2000;
		int h = 2000;
		img = new ImageEx(w, h, 0, 0, 0);
		img.setBgColor(0, 0, 0);
		img.clear();

		img.setColor(255, 195, 0);
		img.kochCurve(500, 750, 500, 250, 10);

		img.save("kochCurve");

	}

	public void regionFill(int x, int y, int reference_rgb) {

		
		if(reference_rgb == img.getRGB(x, y);){

		}


	}

	public static void drawRegionFill(String fileName) {

		int w = 512;
		int h = 512;

		img = new ImageEx(w, h, 0, 0, 0);

		img.setColor(255, 195, 0);

	}

	public static void main(String[] args) {
		drawKochCurve();
	}

}