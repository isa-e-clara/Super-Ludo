package pt.c02oo.s03project.s04ludo.Control;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import pt.c02oo.s03project.s04ludo.Exceptions.OpcaoVaziaBotException;
import pt.c02oo.s03project.s04ludo.Exceptions.OpcaoVaziaQtdJogadoresException;
import pt.c02oo.s03project.s04ludo.Model.Jogador;
import pt.c02oo.s03project.s04ludo.Model.Pessoa;
import pt.c02oo.s03project.s04ludo.Model.Tabuleiro;
import pt.c02oo.s03project.s04ludo.Model.Maquinas.MaquinaAleatoria;
import pt.c02oo.s03project.s04ludo.Model.Maquinas.MaquinaInteligente;
import pt.c02oo.s03project.s04ludo.Model.Maquinas.MaquinaRapida;

public class Controle {
	private Jogador jogador1, jogador2, jogador3, jogador4;
	private int qtdJogadores; 
	private int modo; //0 para multiplayer e 1 para single player (contra maquina)
	private Tabuleiro tabuleiro;
	private int bot;
	private int jogadorAtual; //eh pra marcar o numero de quem esta na vez de jogar
	private boolean fimDeJogo; 
	private int numDado;
	private ArrayList<Jogador> jogadores = new ArrayList<>();
	
	public Controle(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.jogadorAtual = -1; //sempre comeca com a posicao 0 da lista de ordem dos jogadores; dai to colocando -1 pq ele soma 1 na funcao
		this.fimDeJogo = false; 
		this.jogador1 = null;
		this.jogador2 = null;
		this.jogador3 = null;
		this.jogador4 = null;
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public String corSelecionada(int num) { 
		if (num == 1)						
			return "vermelho"; 
		else if(num == 2)
			return "verde"; 
		else if(num == 3)
			return "azul";
		else //if(num == 4)
			return "amarelo";
	}										

	public void criaJogadores() {
		if(modo == 1) {
			jogador1 = new Pessoa(corSelecionada(1), tabuleiro);
			jogadores.add(jogador1);
			if(bot == 0)
				jogador2 = new MaquinaAleatoria(corSelecionada(2), tabuleiro);
			else if(bot == 1)
				jogador2 = new MaquinaInteligente(corSelecionada(2), tabuleiro);
			else //bot == 2
				jogador2 = new MaquinaRapida(corSelecionada(2), tabuleiro);
			jogadores.add(jogador2);
		} else {
			jogador1 = new Pessoa(corSelecionada(1), tabuleiro); //sempre vai ter pelo menos 2 jogadores nesse modo
			jogadores.add(jogador1);
			jogador2 = new Pessoa(corSelecionada(2), tabuleiro);
			jogadores.add(jogador2);
			if(qtdJogadores == 3 || qtdJogadores == 4) {
				jogador3 = new Pessoa(corSelecionada(3), tabuleiro);
				jogadores.add(jogador3);
			}
			if(qtdJogadores == 4) {
				jogador4 = new Pessoa(corSelecionada(4), tabuleiro);
				jogadores.add(jogador4);
			}
		}
	}
	
	public void retirarJogador(Jogador jogador) {
		for(int i = 0; i < qtdJogadores; i++) {
			if(jogadores.get(i) == jogador) {
				jogadores.remove(i);
				break;
			}
		}
		qtdJogadores -= 1;
	}
	
	public void botEscolhido() { //funcao para pegar da interface contra qual maquina a pessoa quer jogar
		String[] options = {"Aleatorio", "Inteligente", "Rapido"}; // 0 para aleatoria, 1 para inteligente, 2 para rapida
		try {
			bot = (JOptionPane.showOptionDialog(null, "Selecione o bot contra qual deseja jogar", "Quase la!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null));
			if(bot == -1) //fechou a janela sem selecionar uma opcao
				throw new OpcaoVaziaBotException();			
		} catch (OpcaoVaziaBotException e) {
			botEscolhido();
		}
	}
	
	public Jogador definirProximoJogador() {
		if(jogadorAtual + 1 < qtdJogadores) {
			jogadorAtual += 1;
			return (jogadores.get(jogadorAtual));	
		} else {
			jogadorAtual = 0;
			return (jogadores.get(0)); //volta para o inicio da lista
		}
	}
	
	public void rodarDado() { 
		numDado = tabuleiro.dado();
	}
	
	public void jogar() {	
		Jogador jogador = definirProximoJogador();
		rodarDado();
		jogador.fazerJogada(numDado);
		if(jogador.jogadorGanhou() == true) {
			retirarJogador(jogador); 
			JOptionPane.showMessageDialog(null, "Parabens!!! Jogador " + jogador.getCor() + " ganhou!"); 
			if(qtdJogadores == 1) {
				fimDeJogo = true;
			}
		}
	}
	
	public void iniciarJogo() { 
		while(fimDeJogo == false) {
			jogar();
		}
		JOptionPane.showMessageDialog(null, "Fim de jogo!");	
	}

	public void definirQtdJogadores() {
        String[] options = {"1", "2", "3", "4"};
		try {
			this.qtdJogadores = (JOptionPane.showOptionDialog(null, "Selecione o numero de jogadores", "Bem vindo!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null)) + 1;
            if(this.qtdJogadores == 0) //fechou a tela sem selecionar nada
                throw new OpcaoVaziaQtdJogadoresException();
			
		} catch (OpcaoVaziaQtdJogadoresException e) {
			definirQtdJogadores();
		}
		setQtdJogadores();
	}

	public void setQtdJogadores() {
		if(qtdJogadores == 1) {
			modo = 1;
			this.qtdJogadores += 1; //acrescentando a maquina na contagem dos jogadores
			botEscolhido();
		} else {
			modo = 0;
		}
	}

	public Jogador getJogador1() {
		return jogador1;
	}
	
	public Jogador getJogador2() {
		return jogador2;
	}

	public Jogador getJogador3() {
		return jogador3;
	}

	public Jogador getJogador4() {
		return jogador4;
	}
	
}