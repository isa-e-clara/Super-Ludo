package pt.c02oo.s03project.s04ludo;
import java.util.ArrayList;

public class Controle {
	private Jogador jogador1, jogador2, jogador3, jogador4;
	private int qtdJogadores; //se alguem ganhar, atualizar esse e o de cima (tirar um jogador) que ai acaba o jogo quando n tiver mais jogadores ativos
	private int modo; //0 para multiplayer e 1 para single player (contra maquina)
	private Tabuleiro tabuleiro;
	private int proximoJogador; //� pra marcar o numero de quem esta na vez de jogar
	private boolean fimDeJogo; //isso eh pra avisar pra main qnd o jogo terminou; LEMBRAR DE IR ATUALIZANDO ISSO EM ALGUM LUGAR e ter a opcao de sair do jogo tbm
	private int numDado;
	private ArrayList<Jogador> jogadores = new ArrayList<>();
	
	public Controle(int qtdJogadores, Tabuleiro tabuleiro) {
		this.qtdJogadores = qtdJogadores;
		if(qtdJogadores == 1) {
			this.modo = 1;
			this.qtdJogadores += 1; //acrescentando a maquina na contagem dos jogadores
		} else {
			this.modo = 0;
		}
		
		this.tabuleiro = tabuleiro;
		this.proximoJogador = 0; //sempre comeca com a posicao 0 da lista de ordem dos jogadores
		this.fimDeJogo = false; 
		this.jogador1 = null;
		this.jogador2 = null;
		this.jogador3 = null;
		this.jogador4 = null;
	}
	
	public String corSelecionada(int num) { //fun��o para pegar a cor que a pessoa escolheu para jogar, nsei se deveria estar aqui e nem como fazer isso ainda, pois depende da interface
		return "";							//num seria o numero do jogador
	}										//colocar um if qnd for pra escolher a cor da maquina (random)
	
	public void criaJogadores() {
		if(modo == 1) {
			jogador1 = new Pessoa(corSelecionada(1), tabuleiro);
			jogadores.add(jogador1);
			jogador2 = new Maquina(corSelecionada(2), tabuleiro);
			jogadores.add(jogador2);
		} else {
			jogador1 = new Pessoa(corSelecionada(1), tabuleiro); //sempre vai ter pelo menos 2 jogadores nesse modo
			jogadores.add(jogador1);
			jogador2 = new Pessoa(corSelecionada(2), tabuleiro);
			jogadores.add(jogador2);
			if(qtdJogadores == 3) {
				jogador3 = new Pessoa(corSelecionada(3), tabuleiro);
				jogadores.add(jogador3);
			}
			else if(qtdJogadores == 4) {
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
	
	public void iniciarJogo() {
		//lembrar de checar qnd o jogo acabar de vez
		
	}
	
	public Jogador definirProximoJogador() {
		if(proximoJogador + 1 <= qtdJogadores)
			return (jogadores.get(proximoJogador + 1));	
		else
			return (jogadores.get(0)); //volta para o inicio da lista
	}
	
	public void rodarDado() { 
		numDado = tabuleiro.dado();
		tabuleiro.atualizarView(numDado);
	}
	
	public void jogar() {	
		rodarDado();
		Jogador jogadorAtual = definirProximoJogador();
		jogadorAtual.fazerJogada(numDado);
		if(jogadorAtual.jogadorGanhou() == true) {
			retirarJogador(jogadorAtual); //colocar alguma mensagem de vitoria
			if(qtdJogadores == 1) {
				fimDeJogo = true;
			}
		}
	}
	
}