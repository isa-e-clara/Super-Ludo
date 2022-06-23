package pt.c02oo.s03project.s04ludo;
import java.util.Random;

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
					celulas[i][j] = new CelulaEstrela(i, j, "null");
					celulas[i][j].definirProxima(6, 13); //prox normal
				} else if(i == 6 && (j <= 5 || j >= 9)) {
					if (j == 1)
						celulas[i][j] = new CelulaEstrela(i, j, "vermelho");
					else
						celulas[i][j] = new Celula("null", i, j);
					if(j == 5)
						celulas[i][j].definirProxima(5, 6);
					else if(j == 14)
						celulas[i][j].definirProxima(7, 14);
					else
						celulas[i][j].definirProxima(6, j + 1);
				} else if(i == 8 && j == 2) {
					celulas[i][j] = new CelulaEstrela(i, j, "null");
					celulas[i][j].definirProxima(8, 1); //prox normal
				} else if(i == 8 && (j <= 5 || j >= 9)) {
					if (j == 13)
						celulas[i][j] = new CelulaEstrela(i, j, "azul");
					else
						celulas[i][j] = new Celula("null", i, j);
					if(j == 0)
						celulas[i][j].definirProxima(7, 0);
					else if(j == 9)
						celulas[i][j].definirProxima(9, 8);
					else
						celulas[i][j].definirProxima(8, j - 1);
				} else if(i == 2 && j == 6) {
					celulas[i][j] = new CelulaEstrela(i, j, "null");
					celulas[i][j].definirProxima(1, 6); //prox normal
				} else if(j == 6 && (i <= 5 || i >= 9)) {
					if (i == 13)
						celulas[i][j] = new CelulaEstrela(i, j, "amarelo");
					else
						celulas[i][j] = new Celula("null", i, j);
					if(i == 0)
						celulas[i][j].definirProxima(0, 7);
					else if(i == 9)
						celulas[i][j].definirProxima(8, 5);
					else
						celulas[i][j].definirProxima(i - 1, 6);
				} else if(i == 12 && j == 8) {
					celulas[i][j] = new CelulaEstrela(i, j, "null");
					celulas[i][j].definirProxima(13, 8); //prox normal
				} else if(j == 8 && (i <= 5 || i >= 9)) {
					if (i == 1)
						celulas[i][j] = new CelulaEstrela(i, j, "verde");
					else
						celulas[i][j] = new Celula("null", i, j);
					if(i == 5)
						celulas[i][j].definirProxima(6, 9);
					else if(i == 14)
						celulas[i][j].definirProxima(14, 7);
					else
						celulas[i][j].definirProxima(i + 1, 6);
				} else if((i == 7 && j == 0) || (i == 0 && j == 7) || (i == 7 && j == 14) || (i == 14 && j == 7)) {
					celulas[i][j] = new Celula("null", i, j);
					celulas[i][j].definirProxima(-1, -1); //a proxima posicao depende da cor de cada peca, fazer um if quando tiver movendo a peca para ver isso
				} else if(i == 7 && j <= 5 && j > 0) {
					celulas[i][j] = new Celula("vermelho", i, j);
					celulas[i][j].definirProxima(7, j + 1);
				} else if(j == 7 && i <= 5 && i > 0) {
					celulas[i][j] = new Celula("verde", i, j);
					celulas[i][j].definirProxima(i + 1, 7);
				} else if(i == 7 && j >= 9 && j < 14) {
					celulas[i][j] = new Celula("azul", i, j);
					celulas[i][j].definirProxima(7, j - 1);
				} else if(j == 7 && i >= 9 && i < 14) {
					celulas[i][j] = new Celula("amarelo", i, j);
					celulas[i][j].definirProxima(i - 1, 7);
				} else {
					celulas[i][j] = null;
				}
				//para as celulas (7,0) (0,7)(7,14)e(14,7), ptoxiimo deve ser definido pela funcao dentro de peca
				
			}
				
	}
	
	public Celula getCelula( int x, int y) {
		return celulas[x][y];
	}
	
	public void come (int x, int y) {
		while (celulas[x][y].retornaPeca() != null) {
			Peca pecaComida = celulas[x][y].retornaPeca();
			celulas[x][y].desconectaPeca(pecaComida);
			celulas[pecaComida.getBaseX()][pecaComida.getBaseY()].conectaPeca(pecaComida);
			pecaComida.setX(pecaComida.getBaseX());
			pecaComida.setY(pecaComida.getBaseY());
			atualizarView(pecaComida.getBaseX(),pecaComida.getBaseY()); //eh aqui mesmo??
		}		
	}

	public void moverPeca(Peca peca, int numDado) {
		//vamos ignorar a barreira
		//checar se pode mover vai ser la no fazer jogada
		boolean ehDupla = false;
		for (int i = 0; i < numDado; i++) {
			int x = peca.getX();
			int y = peca.getY();
			
			if(celulas[x][y].getProxX() == -1 && celulas[x][y].getProxY() == -1) { //casinha dupla
				peca.defineProxima();
				ehDupla = true;
			}
			
			atualizarView(celulas[x][y].getProxX(), celulas[x][y].getProxY()); //eh aqui mesmo??
			
			//esse i == numDado - 1 eh pra checar se eh a ultima andada
			if (i == numDado - 1 && (celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()].getCorPeca() != peca.getCor()) ) { //vai comer
				come(celulas[x][y].getProxX(),celulas[x][y].getProxY());	
			}

			//celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()].desconectaPeca(peca);
			//desconectando a peca da celula antiga e conectando na nova
			celulas[x][y].desconectaPeca(peca);
			celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()].conectaPeca(peca);
			
			//alterando o x e y da peca para o da nova posicao
			peca.setX(celulas[x][y].getProxX());
			peca.setY(celulas[x][y].getProxY());
			
			//verificando se chegou na celula final (ganhou):
			if((peca.getX() == 7 && peca.getY() == 6) || (peca.getX() == 6 && peca.getY() == 7) || (peca.getX() == 7 && peca.getY() == 8) || (peca.getX() == 8 && peca.getY() == 7)) {
				peca.setGanhou(true);
				break;
			}
			
			if(ehDupla == true) { //se era uma celula com duas opcoes de caminho
				celulas[x][y].setProximaX(-1);
				celulas[x][y].setProximaY(-1);
			}
		}
	}
	
	public int dado() {
		Random rand = new Random();
		int randomNum = rand.nextInt(6) + 1;
		return randomNum;
	}
	
	//sobrecarga:
	public void atualizarView(int numDado) { //numDado eh o numero q foi tirado no dado
		//funcao para atualizar o view do dado qnd mudar o numero ou algo do tipo
	}
	
	public void atualizarView(int x, int y) {
		//funcao para atualizar o view qnd acontecer algum movimento
	}
	
	public void conectaPecaCelula(int x, int y, Peca peca) {
		celulas[x][y].conectaPeca(peca);
	}
	
	
}