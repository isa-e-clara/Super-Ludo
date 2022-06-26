package pt.c02oo.s03project.s04ludo;
import java.util.ArrayList;

public class Controle {
	private Jogador jogador1, jogador2, jogador3, jogador4;
	private int qtdJogadores; 
	private int modo; //0 para multiplayer e 1 para single player (contra maquina)
	private Tabuleiro tabuleiro;
	private int bot;
	private int jogadorAtual; //eh pra marcar o numero de quem esta na vez de jogar
	private boolean fimDeJogo; //isso eh pra avisar pra main qnd o jogo terminou
	private int numDado;
	private ArrayList<Jogador> jogadores = new ArrayList<>();
	private View view;
	
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

	public void conectaView(View view) {
		this.view = view;
	}
	
	public String corSelecionada(int num) { //funcao para pegar a cor que a pessoa escolheu para jogar, nsei se deveria estar aqui e nem como fazer isso ainda, pois depende da interface
		if (num ==1)
			return "vermelho"; //lembrar de consertar
		else
			return "azul";						//num seria o numero do jogador
	}										//colocar um if qnd for pra escolher a cor da maquina (random)
	
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
	
	public int quantidadeJogadores() { //funcao para pegar da interface a qtd de jogadores
		return 2; //lembrar de mudar
	}
	
	public int botEscolhido() { //funcao para pegar da interface contra qual maquina a pessoa quer jogar
		return 0;				// 0 para aleatoria, 1 para inteligente, 2 para rapida
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
		tabuleiro.atualizarView(numDado);
	}
	
	public void jogar() {	
		rodarDado();
		Jogador jogador = definirProximoJogador();
		jogador.fazerJogada(numDado);
		if(jogador.jogadorGanhou() == true) {
			retirarJogador(jogador); //colocar alguma mensagem de vitoria
			if(qtdJogadores == 1) {
				fimDeJogo = true;
			}
		}
	}
	
	public void iniciarJogo() { //se tud tiver certo, a gnt so precisa criar um controle e chamar essa funcao na main
		//lembrar de checar qnd o jogo acabar de vez
		//qtdJogadores = quantidadeJogadores();
		//if(qtdJogadores == 1) {
		//	modo = 1;
		//	qtdJogadores += 1; //acrescentando a maquina na contagem dos jogadores
		//	bot = botEscolhido();
		//} else {
		//	modo = 0;
		//}
		//criaJogadores();
		
		while(fimDeJogo == false) {

			jogar();
		}
		
	}

	public void setQtdJogadores(int qtdJogadores) {
		this.qtdJogadores = qtdJogadores;
		if(qtdJogadores == 1) {
			modo = 1;
			qtdJogadores += 1; //acrescentando a maquina na contagem dos jogadores
			bot = botEscolhido();
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
	
}