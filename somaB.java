public static int somaB(int [] a, int ini, int fim){

	if(ini == fim) return a[ini];                // caso base n = 1
	if(ini + 1 == fim) return a[ini] + a[fim];   // caso base n = 2

	// caso geral
	int med = (ini + fim) / 2;
	return somaB(a, ini, med) + somaB(a, med + 1, fim);
}

