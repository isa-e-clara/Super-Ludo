package pt.c02oo.s03project.s04ludo;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Pessoa extends Jogador{

	public Pessoa(String cor, Tabuleiro tabuleiro) {
		super(cor, tabuleiro);
	}

	public void fazerJogada(int numDado) {
		super.fazerJogada(numDado);

		if(numDado == 1 || numDado == 6) {
			for(int i = 0; i < pecasBase.size(); i++) {
				pecasDisponiveis.add(pecasBase.get(i));
			}
		}

		int size = pecasDisponiveis.size();
		int option;

		if(size == 0) {
			String[] options = {"continuar"};
			option = (JOptionPane.showOptionDialog(null, "Voce nao pode mover nenhuma peca :(", "Vez do Jogador " + this.cor, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null));
		} else if(size == 1) { //colocar um exception se a pessoa n selecionar nenhuma e so fechar a janela
			String[] options = {Integer.toString(pecasDisponiveis.get(0).getNumero())};
			option = (JOptionPane.showOptionDialog(null, "Selecione a peca que deseja mover", "Vez do Jogador " + this.cor, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null));
			mover(pecasDisponiveis.get(option), numDado);
		} else if(size == 2) {
			String[] options = {Integer.toString(pecasDisponiveis.get(0).getNumero()), Integer.toString(pecasDisponiveis.get(1).getNumero())};
			option = (JOptionPane.showOptionDialog(null, "Selecione a peca que deseja mover", "Vez do Jogador " + this.cor, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null));
			mover(pecasDisponiveis.get(option), numDado);
		} else if(size == 3) {
			String[] options = {Integer.toString(pecasDisponiveis.get(0).getNumero()), Integer.toString(pecasDisponiveis.get(1).getNumero()), Integer.toString(pecasDisponiveis.get(2).getNumero())};
			option = (JOptionPane.showOptionDialog(null, "Selecione a peca que deseja mover", "Vez do Jogador " + this.cor, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null));
			mover(pecasDisponiveis.get(option), numDado);
		} else if(size == 4) {
			String[] options = {Integer.toString(pecasDisponiveis.get(0).getNumero()), Integer.toString(pecasDisponiveis.get(1).getNumero()), Integer.toString(pecasDisponiveis.get(2).getNumero()), Integer.toString(pecasDisponiveis.get(3).getNumero())};
			option = (JOptionPane.showOptionDialog(null, "Selecione a peca que deseja mover", "Vez do Jogador " + this.cor, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null));
			mover(pecasDisponiveis.get(option), numDado);
		}

		
		// if (peca1.getGanhou() == false)
		// 	mover(peca1, numDado);
		// else if (peca2.getGanhou() == false)
		// 	mover(peca2, numDado);
		// else if (peca3.getGanhou() == false)
		// 	mover(peca3, numDado);
		// else if (peca4.getGanhou() == false)
		// 	mover(peca4, numDado);
	    // System.out.println("Digite o numero da peca: ");
	    // Scanner entrada = new Scanner(System.in);
	    // char comando;
	    // comando = entrada.next().charAt(0);
	    // if(comando == '1')
	    // 	mover(peca1, numDado);
	    // else if(comando == '2')
	    // 	mover(peca2, numDado);
	    // else if(comando == '3')
	    // 	mover(peca3, numDado);
	    // else if(comando == '4')
	    // 	mover(peca4, numDado);
	    // else {
	    // 	//erro
	    //}
	}

	// public void keyTyped(KeyEvent tecla) {
	// 	int codigo = tecla.getKeyCode();
	// 	//System.out.println(tecla.getKeyCode());

	// 	if (codigo == KeyEvent.VK_1) {
	// 		mover(peca1, 4);
	// 		//int proxX = tabuleiro.getCelula(peca1.getX(), peca1.getY()).getProxX();
	// 		//int proxY = tabuleiro.getCelula(peca1.getX(), peca1.getY()).getProxY();
	// 		//peca1.update(proxX, proxY);
	// 	}
	// }
		
}
