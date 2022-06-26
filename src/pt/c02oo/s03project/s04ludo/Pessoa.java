package pt.c02oo.s03project.s04ludo;
import java.awt.event.KeyEvent;

public class Pessoa extends Jogador{

	public Pessoa(String cor, Tabuleiro tabuleiro) {
		super(cor, tabuleiro);
	}

	public void fazerJogada(int numDado) {
		super.fazerJogada(numDado); 
		mover(peca1, 4);
	}

	public void keyTyped(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_1) {
			int proxX = tabuleiro.getCelula(peca1.getX(), peca1.getY()).getProxX();
			int proxY = tabuleiro.getCelula(peca1.getX(), peca1.getY()).getProxY();
			peca1.update(proxX, proxY);
		}
	}
		
}
