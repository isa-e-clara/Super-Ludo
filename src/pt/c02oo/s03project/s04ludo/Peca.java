package pt.c02oo.s03project.s04ludo;

public class Peca {
	private int numero;
	private int x, y;
	private Tabuleiro tabuleiro;
	private String cor;

	public int getNumero() {
		return numero;
	}
	
	public void conectaTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	


	
	
}
