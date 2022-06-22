package pt.c02oo.s03project.s04ludo;

public class Jogador { //acho que ainda deva ter uma interface superior 
	//diferente pra máquina e pra pessoa
	private Peca peca1, peca2, peca3, peca4;
	private String cor;
	private Tabuleiro tabuleiro;
	
	public Jogador(String cor, Tabuleiro tabuleiro) {
		this.cor = cor;
		this.tabuleiro = tabuleiro;
	}
	
	/* acho que n precisa dessa funcao?
	 * 
	 * public void conectaPeca(Peca peca) { int numero = peca.getNumero(); if(numero
	 * == 1) this.peca1 = peca; else if(numero == 2) this.peca2 = peca; else
	 * if(numero == 3) this.peca3 = peca; else if(numero == 4) this.peca4 = peca;
	 * //else //erro, exception }
	 */

	public void inicializarPecas() { 
		if(cor == "vermelho") {
			peca1 = new Peca(2, 2, 1, "vermelho");
			peca2 = new Peca(2, 3, 2, "vermelho");
			peca3 = new Peca(3, 2, 3, "vermelho");
			peca4 = new Peca(3, 3, 4, "vermelho");
		} else if(cor == "verde") {
			peca1 = new Peca(2, 11, 1, "verde");
			peca2 = new Peca(2, 12, 2, "verde");
			peca3 = new Peca(3, 11, 3, "verde");
			peca4 = new Peca(3, 12, 4, "verde");
		} else if(cor == "amarelo") {
			peca1 = new Peca(11, 2, 1, "amarelo");
			peca2 = new Peca(11, 3, 2, "amarelo");
			peca3 = new Peca(12, 2, 3, "amarelo");
			peca4 = new Peca(12, 3, 4, "amarelo");		
		} else if(cor == "azul") {
			peca1 = new Peca(11, 11, 1, "azul");
			peca2 = new Peca(11, 12, 2, "azul");
			peca3 = new Peca(12, 11, 3, "azul");
			peca4 = new Peca(12, 12, 4, "azul");		
		} else {
			//erro
		}
		
		peca1.conectaTabuleiro(tabuleiro);
		peca2.conectaTabuleiro(tabuleiro);
		peca3.conectaTabuleiro(tabuleiro);
		peca4.conectaTabuleiro(tabuleiro);
		
		//conectando as pecas as suas celulas base
		tabuleiro.conectaPecaCelula(peca1.getX(), peca1.getY(), peca1);
		tabuleiro.conectaPecaCelula(peca2.getX(), peca2.getY(), peca2);
		tabuleiro.conectaPecaCelula(peca3.getX(), peca3.getY(), peca3);
		tabuleiro.conectaPecaCelula(peca4.getX(), peca4.getY(), peca4);
		
	}
	
	public void fazerJogada(int numDado) { //essa funcao deve ser responsavel por deixar o jogador selecionar uma peca dentre as disponiveis (pecas na base n podem andar por exemplo)
								//essa funcao pode ja inclusive chamar a mover
	}
	
	public void mover() {} //aqui entra ou a estratégia da máquina ou a escolha de que peca vai andar da pessoa
	//essa funcao deve ser responsavel por mover a peca selecionada pelo jogador

	
}