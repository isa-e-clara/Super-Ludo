package pt.c02oo.s03project.s04ludo;

public class Celula {
	private Peca peca1, peca2, peca3, peca4; //pode ter no maximo quatro peças empilhadas do mesmo time
	private int x, y;
	private int proximaX, proximaY;
	private String cor;

	public Celula(String cor, int x, int y) {
		this.cor = cor;
		this.x = x;
		this.y = y;
		this.peca1 = null;
		this.peca2 = null;
		this.peca3 = null;
		this.peca4 = null;
	}
	
	public void conectaPeca(Peca peca) { 
		int numero = peca.getNumero();
		if(numero == 1)
			this.peca1 = peca;	
		else if(numero == 2)
			this.peca2 = peca;
		else if(numero == 3)
			this.peca3 = peca;
		else if(numero == 4)
			this.peca4 = peca;
		//else
			//erro, exception		
	}
	
	public void desconectaPeca(Peca peca) {
		int numero = peca.getNumero();
		if(numero == 1)
			this.peca1 = null;	
		else if(numero == 2)
			this.peca2 = null;
		else if(numero == 3)
			this.peca3 = null;
		else if(numero == 4)
			this.peca4 = null;
		//else
			//erro, exception				
	}
	
	public void definirProxima(int i, int j) {
		this.proximaX = i;
		this.proximaY = j;
	}

}
