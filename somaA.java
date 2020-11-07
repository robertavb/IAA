public static int somaA(int [] a, int ini, int fim){

	if(ini > fim) return 0;          // caso base n = 0
	if(ini == fim) return a[ini];    // caso base n = 1

	// caso geral
	return a[ini] + somaA(a, ini + 1, fim - 1) + a[fim];
}