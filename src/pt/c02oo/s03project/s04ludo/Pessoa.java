package pt.c02oo.s03project.s04ludo;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import javax.swing.JOptionPane;

import java.util.ArrayList;


public class Pessoa extends Jogador{
	private int option;

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
		this.option = 0; //inicializando com qualquer valor so pra n dar erro

		if(size == 0) {
			String[] options = {"continuar"};
			option = JOptionPane.showOptionDialog(null, "Voce nao pode mover nenhuma peca :(", "Vez do Jogador " + this.cor, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
			if(option == -1) {
				String[] options2 = {"sim", "nao"};
				option = JOptionPane.showOptionDialog(null, "Deseja fechar o jogo?", "VAI DESISTIR??", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, null);
				if(option == 0)
            		System.exit(0);   
			}
			try {
				Thread.sleep(400); //ver se esse tempo ta bom
			} catch(InterruptedException e) {};
		} else {
			try {
				if(size == 1) { 
					String[] options = {Integer.toString(pecasDisponiveis.get(0).getNumero())};
					this.option = (JOptionPane.showOptionDialog(null, "Selecione a peca que deseja mover", "Vez do Jogador " + this.cor, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null));
				} else if(size == 2) {
					String[] options = {Integer.toString(pecasDisponiveis.get(0).getNumero()), Integer.toString(pecasDisponiveis.get(1).getNumero())};
					this.option = (JOptionPane.showOptionDialog(null, "Selecione a peca que deseja mover", "Vez do Jogador " + this.cor, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null));
				} else if(size == 3) {
					String[] options = {Integer.toString(pecasDisponiveis.get(0).getNumero()), Integer.toString(pecasDisponiveis.get(1).getNumero()), Integer.toString(pecasDisponiveis.get(2).getNumero())};
					this.option = (JOptionPane.showOptionDialog(null, "Selecione a peca que deseja mover", "Vez do Jogador " + this.cor, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null));
				} else {//if(size == 4) {
					String[] options = {Integer.toString(pecasDisponiveis.get(0).getNumero()), Integer.toString(pecasDisponiveis.get(1).getNumero()), Integer.toString(pecasDisponiveis.get(2).getNumero()), Integer.toString(pecasDisponiveis.get(3).getNumero())};
					this.option = (JOptionPane.showOptionDialog(null, "Selecione a peca que deseja mover", "Vez do Jogador " + this.cor, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null));
				}
				if(this.option == -1) 
					throw new OpcaoVaziaPecaException();
				
			} catch (OpcaoVaziaPecaException e) {
				fazerJogada(numDado);
			}

			mover(pecasDisponiveis.get(this.option), numDado);	
		}
	}
		
}
