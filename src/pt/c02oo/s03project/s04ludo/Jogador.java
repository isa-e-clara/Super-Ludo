package pt.c02oo.s03project.s04ludo;

import java.util.ArrayList;

public class Jogador { //acho que ainda deva ter uma interface superior 
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
		//listinha com as pecas disponiveis e as da base
		ArrayList<Peca> pecasDisponiveis = new ArrayList(); //ficar de olho nos arrays
        ArrayList<Peca> pecasBase = new ArrayList();
		qtdPecasBase = 0;
		qtdPecasDisponiveis = 0;
		ganhou = false;
		inicializarPecas(); //pode chamar aqui sera? ficar atenta para erros
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
	
	public void fazerJogada(int numDado) { 
		// a funcao monta duas listas, uma de pecas na base e outra de pecas do tabueleiro que podem andar
		//faremos sobrecarga dessa função. nos herdeiros, disponibilizaremos todas as pecas do tabuleiro para escolha
		//e as da base somente se tirar 1 ou 6 (como já feito nas máquinas)

		//na sobrecarga dessa funcao pelas herdeiras entra ou a estrategia da maquina ou a escolha de que peca vai andar da pessoa 	

		Celula celulaChegada;
		boolean podeAndar;

		//pode andar se celula n for estrela, se for estrela sem ninguem, se for estrela com uma peca sua la ouse for estrela da sua cor
		//quando celulaChegada eh null,significa que vai entrar no corredor de chegada ou que vai ganhar se mover

		celulaChegada = tabuleiro.getCelulaChegada(peca1, numDado);
		podeAndar = (celulaChegada == null) || (celulaChegada.ehEstrela == false) || (celulaChegada.ehEstrela == true && celulaChegada.getCorPeca() == "") || (celulaChegada.ehEstrela == true && celulaChegada.getCorPeca() == cor) || (celulaChegada.ehEstrela == true && celulaChegada.getCor() == cor);

		if (peca1.getGanhou() == false && podeAndar == true) { 
			if (peca1.getEstaNaBase() == false) {
				pecasDisponiveis.add(peca1);
				qtdPecasDisponiveis++;
        }
			else {
				pecasBase.add(peca1);
				qtdPecasBase++;
			}
		}

		celulaChegada = tabuleiro.getCelulaChegada(peca2, numDado);
		podeAndar = (celulaChegada.ehEstrela == false) || (celulaChegada.ehEstrela == true && celulaChegada.getCorPeca() == "") || (celulaChegada.ehEstrela == true && celulaChegada.getCorPeca() == cor) || (celulaChegada.ehEstrela == true && celulaChegada.getCor() == cor);

		if (peca2.getGanhou() == false && podeAndar == true) { 
			if (peca2.getEstaNaBase() == false) {
				pecasDisponiveis.add(peca2);
				qtdPecasDisponiveis++;
			}
			else{
				pecasBase.add(peca2);
				qtdPecasBase++;
			}
		}

		celulaChegada = tabuleiro.getCelulaChegada(peca3, numDado);
		podeAndar = (celulaChegada.ehEstrela == false) || (celulaChegada.ehEstrela == true && celulaChegada.getCorPeca() == "") || (celulaChegada.ehEstrela == true && celulaChegada.getCorPeca() == cor) || (celulaChegada.ehEstrela == true && celulaChegada.getCor() == cor);

		if (peca3.getGanhou() == false && podeAndar == true) { 
			if (peca3.getEstaNaBase() == false) {
				pecasDisponiveis.add(peca3);
				qtdPecasDisponiveis++;
			}
			else{
				pecasBase.add(peca3);
				qtdPecasBase++;
			}
		}

		celulaChegada = tabuleiro.getCelulaChegada(peca4, numDado);
		podeAndar = (celulaChegada.ehEstrela == false) || (celulaChegada.ehEstrela == true && celulaChegada.getCorPeca() == "") || (celulaChegada.ehEstrela == true && celulaChegada.getCorPeca() == cor) || (celulaChegada.ehEstrela == true && celulaChegada.getCor() == cor);

		if (peca4.getGanhou() == false && podeAndar == true) { 
			if (peca4.getEstaNaBase() == false) {
				pecasDisponiveis.add(peca4);
				qtdPecasDisponiveis++;
			}
			else{
				pecasBase.add(peca4);
				qtdPecasBase++;
			}
		}
        
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
	
}