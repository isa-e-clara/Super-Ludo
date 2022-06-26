package pt.c02oo.s03project.s04ludo;
import java.awt.event.KeyEvent;
import java.util.Scanner;


public class Pessoa extends Jogador{

	public Pessoa(String cor, Tabuleiro tabuleiro) {
		super(cor, tabuleiro);
	}

	public void fazerJogada(int numDado) {
		super.fazerJogada(numDado); 
	    System.out.println("Digite o numero da peca: ");
	    Scanner entrada = new Scanner(System.in);
	    char comando;
	    comando = entrada.next().charAt(0);
	    if(comando == '1')
	    	mover(peca1, numDado);
	    else if(comando == '2')
	    	mover(peca2, numDado);
	    else if(comando == '3')
	    	mover(peca3, numDado);
	    else if(comando == '4')
	    	mover(peca4, numDado);
	    else {
	    	//erro
	    }
	}

	public void keyTyped(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		//System.out.println(tecla.getKeyCode());

		if (codigo == KeyEvent.VK_1) {
			mover(peca1, 4);
			//int proxX = tabuleiro.getCelula(peca1.getX(), peca1.getY()).getProxX();
			//int proxY = tabuleiro.getCelula(peca1.getX(), peca1.getY()).getProxY();
			//peca1.update(proxX, proxY);
		}
	}
		
}
