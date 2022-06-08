package pt.c02oo.s03project.s04ludo;

public class Tabuleiro {
	private Celula[][] celulas;
	
	public Tabuleiro() {
		celulas = new Celula[15][15];
		for(int i = 0; i < 15; i++)
			for(int j = 0; j < 15; j++) {
				if(i >= 2 && i <= 3 && j >= 2 && j <= 3) {
					celulas[i][j] = new Base("vermelho", i, j);
					celulas[i][j].definirProxima(6, 1);
				} else if(i >= 2 && i <= 3 && j >= 11 && j <= 12) {
					celulas[i][j] = new Base("verde", i, j);
					celulas[i][j].definirProxima(1, 8);
				} else if(i >= 11 && i <= 12 && j >= 2 && j <= 3) {
					celulas[i][j] = new Base("amarelo", i, j);
					celulas[i][j].definirProxima(13, 6);
				} else if(i >= 11 && i <= 12 && j >= 11 && j <= 12) {
					celulas[i][j] = new Base("azul", i, j);
					celulas[i][j].definirProxima(8, 13);
				} else if(i == 6 && j == 12) {
					celulas[i][j] = new CelulaEstrela(i, j);
					celulas[i][j].definirProxima(12, 8); //DEIXAR OU COLOCAR O PROXIMO NORMAL??
				} else if(i == 6 && (j <= 5 || j >= 9)) {
					celulas[i][j] = new Celula("null", i, j);
					if(j == 5)
						celulas[i][j].definirProxima(5, 6);
					else if(j == 14)
						celulas[i][j].definirProxima(7, 14);
					else
						celulas[i][j].definirProxima(6, j + 1);
				} else if(i == 8 && j == 2) {
					celulas[i][j] = new CelulaEstrela(i, j);
					celulas[i][j].definirProxima(2, 6); //DEIXAR OU COLOCAR O PROXIMO NORMAL??
				} else if(i == 8 && (j <= 5 || j >= 9)) {
					celulas[i][j] = new Celula("null", i, j);
					if(j == 0)
						celulas[i][j].definirProxima(7, 0);
					else if(j == 9)
						celulas[i][j].definirProxima(9, 8);
					else
						celulas[i][j].definirProxima(8, j - 1);
				} else if(i == 2 && j == 6) {
					celulas[i][j] = new CelulaEstrela(i, j);
					celulas[i][j].definirProxima(6, 12); //DEIXAR OU COLOCAR O PROXIMO NORMAL??
				} else if(j == 6 && (i <= 5 || i >= 9)) {
					celulas[i][j] = new Celula("null", i, j);
					if(i == 0)
						celulas[i][j].definirProxima(0, 7);
					else if(i == 9)
						celulas[i][j].definirProxima(8, 5);
					else
						celulas[i][j].definirProxima(i - 1, 6);
				} else if(i == 12 && j == 8) {
					celulas[i][j] = new CelulaEstrela(i, j);
					celulas[i][j].definirProxima(8, 2); //DEIXAR OU COLOCAR O PROXIMO NORMAL??
				} else if(j == 8 && (i <= 5 || i >= 9)) {
					celulas[i][j] = new Celula("null", i, j);
					if(i == 5)
						celulas[i][j].definirProxima(6, 9);
					else if(i == 14)
						celulas[i][j].definirProxima(14, 7);
					else
						celulas[i][j].definirProxima(i + 1, 6);
				} else if((i == 7 && j == 0) || (i == 0 && j == 7) || (i == 7 && j == 14) || (i == 14 && j == 7)) {
					celulas[i][j] = new Celula("null", i, j);
					celulas[i][j].definirProxima(-1, -1); //a proxima posi��o depende da cor de cada pe�a, fazer um if quando tiver movendo a pe�a para ver isso
				} else if(i == 7 && j <= 5) {
					celulas[i][j] = new Celula("vermelho", i, j);
					celulas[i][j].definirProxima(7, j + 1);
				} else if(j == 7 && i <= 5) {
					celulas[i][j] = new Celula("verde", i, j);
					celulas[i][j].definirProxima(i + 1, 7);
				} else if(i == 7 && j >= 9) {
					celulas[i][j] = new Celula("azul", i, j);
					celulas[i][j].definirProxima(7, j - 1);
				} else if(j == 7 && j >= 9) {
					celulas[i][j] = new Celula("amarelo", i, j);
					celulas[i][j].definirProxima(i - 1, 7);
				}
				
			}
				
	}
	
	
	public void conectaPecaCelula(int x, int y, Peca peca) {
		celulas[x][y].conectaPeca(peca);
	}
	
	
}
