package pt.c02oo.s03project.s04ludo.Model.Celulas;

import pt.c02oo.s03project.s04ludo.Model.Peca;

public class Celula {
	protected Peca peca1, peca2, peca3, peca4; //pode ter no maximo quatro pecas empilhadas do mesmo time
	protected int x, y;
	protected int proximaX, proximaY, anteriorX, anteriorY;;
	protected String cor;
	protected boolean ehEstrela;

	public Celula(String cor, int x, int y) {
		this.cor = cor;
		this.x = x;
		this.y = y;
		peca1 = null;
		peca2 = null;
		peca3 = null;
		peca4 = null;
		ehEstrela = false;
		proximaX = -3; //quando ganhar, não definimos a próxima, ou seja, sempre será -3
		proximaY = -3;
		anteriorX = -3;
		anteriorY = -3;
	}

	public String getCor() {
		return cor;
	}

	public void setProximaX(int proximaX) {
		this.proximaX = proximaX;
	}

	public void setProximaY(int proximaY) {
		this.proximaY = proximaY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getProxY() {
		return proximaY;
	}
	
	public int getProxX() {
		return proximaX;
	}
	
	public void conectaPeca(Peca peca) { 
		int numero = peca.getNumero();
		if(numero == 1)
			this.peca1 = peca;	
		else if(numero == 2)
			this.peca2 = peca;
		else if(numero == 3)
			this.peca3 = peca;
		else //if(numero == 4)
			this.peca4 = peca;	
	}
	
	public void desconectaPeca(Peca peca) {
		int numero = peca.getNumero();
		if(numero == 1)
			this.peca1 = null;	
		else if(numero == 2)
			this.peca2 = null;
		else if(numero == 3)
			this.peca3 = null;
		else //if(numero == 4)
			this.peca4 = null;			
	}
	
	public void definirProxima(int i, int j) {
		this.proximaX = i;
		this.proximaY = j;
	}

	public void definirAnterior(int i, int j) {
		this.anteriorX = i;
		this.anteriorY = j;
	}

	public int getXAnterior () {
		return anteriorX;
	}

	public int getYAnterior () {
		return anteriorY;
	}

	public String getCorPeca() {
		if (peca1 != null) 
			return peca1.getCor();
		else if (peca2 != null) 
			return peca2.getCor();
		else if (peca3 != null) 
			return peca3.getCor();
		else if (peca4 != null) 
			return peca4.getCor();
		else
			return "";
	}

	public Peca retornaPeca () {
		if (peca1 != null) 
			return peca1;
		else if (peca2 != null) 
			return peca2;
		else if (peca3 != null) 
			return peca3;
		else if (peca4 != null) 
			return peca4;
		else
			return null; 
	}

	public Peca pecaNumero(int num) { //retorna peca de determinado numero
		if(num == 1)
			return peca1;
		else if(num == 2)
			return peca2;
		else if(num == 3)
			return peca3;
		else //if(num == 4)
			return peca4;
	}

	public Peca getPeca1() {
		return peca1;
	}

	public Peca getPeca2() {
		return peca2;
	}

	public Peca getPeca3() {
		return peca3;
	}

	public Peca getPeca4() {
		return peca4;
	}

	public boolean getEhEstrela() {
		return ehEstrela;
	}

}