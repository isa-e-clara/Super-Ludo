package pt.c02oo.s03project.s04ludo.Model;
import java.util.ArrayList;

import pt.c02oo.s03project.s04ludo.Interfaces.IJogador;
import pt.c02oo.s03project.s04ludo.Model.Celulas.Celula;

public class Jogador implements IJogador{ 
	protected Peca peca1, peca2, peca3, peca4;
	protected String cor;
	protected Tabuleiro tabuleiro;
	protected ArrayList<Peca> pecasDisponiveis;
    protected ArrayList<Peca> pecasBase;
	protected int qtdPecasDisponiveis;
	protected int qtdPecasBase;
	protected boolean ganhou;
	
	public Jogador(String cor, Tabuleiro tabuleiro) {
		this.cor = cor;
		this.tabuleiro = tabuleiro;
		ganhou = false;
		inicializarPecas(); 
	}

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
		} else { //if(cor == "azul") 
			peca1 = new Peca(11, 11, 1, "azul");
			peca2 = new Peca(11, 12, 2, "azul");
			peca3 = new Peca(12, 11, 3, "azul");
			peca4 = new Peca(12, 12, 4, "azul");		
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

	public void fazVerificacao(Peca peca, int numDado) {
		Celula celulaChegada;
		boolean podeAndar;

		celulaChegada = tabuleiro.getCelulaChegada(peca, numDado);
		if (celulaChegada == null)
			podeAndar = true;
		else if (celulaChegada != tabuleiro.getCelula(peca.getX(), peca.getY()))
			podeAndar = (celulaChegada.getEhEstrela() == false) || (celulaChegada.getEhEstrela() == true && celulaChegada.getCorPeca() == "") || (celulaChegada.getEhEstrela() == true && celulaChegada.getCorPeca() == cor) || (celulaChegada.getEhEstrela() == true && celulaChegada.getCor() == cor);
		else
			podeAndar = false;
		if (peca.getGanhou() == false && podeAndar == true) { 
			if (peca.getEstaNaBase() == false) {
				pecasDisponiveis.add(peca);
				qtdPecasDisponiveis++;
        	}
			else {
				pecasBase.add(peca);
				qtdPecasBase++;
			}
		}
	}

	// a funcao monta duas listas, uma de pecas na base e outra de pecas do tabueleiro que podem andar, para que o Jogador possa escolher qual mover
	public void fazerJogada(int numDado) { 
		qtdPecasBase = 0;
		qtdPecasDisponiveis = 0;
		pecasDisponiveis = new ArrayList(); 
        pecasBase = new ArrayList();

		//pode andar se celula n for estrela, se for estrela sem ninguem, se for estrela com uma peca sua la ou se for estrela da sua cor
		//quando celulaChegada eh null, significa que vai entrar no corredor de chegada ou que vai ganhar se mover
		fazVerificacao(peca1, numDado);
		fazVerificacao(peca2, numDado);
		fazVerificacao(peca3, numDado);
		fazVerificacao(peca4, numDado);

    }
	
	public boolean jogadorGanhou() {
		if((peca1.getGanhou() == true) && (peca2.getGanhou() == true) && (peca3.getGanhou() == true) && (peca4.getGanhou() == true)) {
			ganhou = true;
			return true;
		}
		return false;
	}
	
	public void mover(Peca peca, int numDado) {
		//lidar com pecas empilhadas -> ver todas as pecas q estao na celula e mover
		Celula celula = tabuleiro.getCelula(peca.getX(), peca.getY());
		if (celula.getPeca1() != null)
			tabuleiro.moverPeca(celula.getPeca1(), numDado);
		if (celula.getPeca2() != null)
			tabuleiro.moverPeca(celula.getPeca2(), numDado);
		if (celula.getPeca3() != null)
			tabuleiro.moverPeca(celula.getPeca3(), numDado);
		if (celula.getPeca4() != null)
			tabuleiro.moverPeca(celula.getPeca4(), numDado);
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

	public Peca getPeca1(){
		return peca1;
	}
	
	public String getCor() {
		return cor;
	}

}