package pt.c02oo.s03project.s04ludo;

public class Peca {
	private int numero;
	private int x, y;
	private Tabuleiro tabuleiro;
	private String cor;
	private boolean estaNaBase;
	
	public Peca(int x, int y, int numero, String cor) {
		this.x = x;
		this.y = y;
		this.numero = numero;
		this.cor = cor;
		this.estaNaBase = true; //a principio todas as pecas comecam na base
	}
	
	public int getNumero() {
		return numero;
	}
	
	public boolean getEstaNaBase() {
		return estaNaBase;
	}

	public void setEstaNaBase(boolean estaNaBase) {
		this.estaNaBase = estaNaBase;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void conectaTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void defineProxima() { //define as proximas posicoes para as pecas que estao em casas com duas poss�veis pr�ximas
		if (x == 7 && y == 0) {
			if (cor == "vermelho") 
				tabuleiro.getCelula(7, 0).definirProxima(7,1);
			else
				tabuleiro.getCelula(7, 0).definirProxima(6,0);
		}
		else if (x == 7 && y == 14) {
			if (cor == "azul") 
				tabuleiro.getCelula(7, 14).definirProxima(7,13);
			else
				tabuleiro.getCelula(7, 14).definirProxima(8,14);
		}
		else if (x == 0 && y == 7) {
			if (cor == "verde") 
				tabuleiro.getCelula(0,7).definirProxima(1,7);
			else
				tabuleiro.getCelula(0,7).definirProxima(0,8);
		}
		else if (x == 14 && y == 7) {
			if (cor == "verde") 
				tabuleiro.getCelula(14,7).definirProxima(13,7);
			else
				tabuleiro.getCelula(14,7).definirProxima(14,6);
		}	
	}
	

	
}