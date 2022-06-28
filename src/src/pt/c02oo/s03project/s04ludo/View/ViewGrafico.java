package pt.c02oo.s03project.s04ludo.View;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pt.c02oo.s03project.s04ludo.Interfaces.*;
import pt.c02oo.s03project.s04ludo.Control.Controle;

import java.awt.Graphics;
import java.awt.Graphics2D;


public class ViewGrafico extends JPanel implements Observer{
    private Image fundo;
    private Controle controle;
	private Image dado1 = (new ImageIcon("assets\\1.jpg")).getImage(); 
	private Image dado2 = (new ImageIcon("assets\\2.jpg")).getImage(); 
	private Image dado3 = (new ImageIcon("assets\\3.jpg")).getImage(); 
	private Image dado4 = (new ImageIcon("assets\\4.jpg")).getImage(); 
	private Image dado5 = (new ImageIcon("assets\\5.jpg")).getImage(); 
	private Image dado6 = (new ImageIcon("assets\\6.jpg")).getImage(); 

    public ViewGrafico(Controle controle) {
        this.controle = controle;
        ImageIcon referencia = new ImageIcon("assets\\tabuleiro_novo.png");
        fundo = referencia.getImage();
    }

    public Image getFundo() {
		return fundo;
	}

    public void update() {
        updateUI();
        try {
            Thread.sleep(200);
        } catch(InterruptedException e) {};
    }

	public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        
        graficos.drawImage(controle.getJogador1().getPeca1().getImage(), controle.getJogador1().getPeca1().getXSpawn(), controle.getJogador1().getPeca1().getYSpawn(), this);
        graficos.drawImage(controle.getJogador1().getPeca2().getImage(), controle.getJogador1().getPeca2().getXSpawn(), controle.getJogador1().getPeca2().getYSpawn(), this);
        graficos.drawImage(controle.getJogador1().getPeca3().getImage(), controle.getJogador1().getPeca3().getXSpawn(), controle.getJogador1().getPeca3().getYSpawn(), this);
        graficos.drawImage(controle.getJogador1().getPeca4().getImage(), controle.getJogador1().getPeca4().getXSpawn(), controle.getJogador1().getPeca4().getYSpawn(), this);

        graficos.drawImage(controle.getJogador2().getPeca1().getImage(), controle.getJogador2().getPeca1().getXSpawn(), controle.getJogador2().getPeca1().getYSpawn(), this);
        graficos.drawImage(controle.getJogador2().getPeca2().getImage(), controle.getJogador2().getPeca2().getXSpawn(), controle.getJogador2().getPeca2().getYSpawn(), this);
        graficos.drawImage(controle.getJogador2().getPeca3().getImage(), controle.getJogador2().getPeca3().getXSpawn(), controle.getJogador2().getPeca3().getYSpawn(), this);
        graficos.drawImage(controle.getJogador2().getPeca4().getImage(), controle.getJogador2().getPeca4().getXSpawn(), controle.getJogador2().getPeca4().getYSpawn(), this);

        if(controle.getJogador3() != null) {
	        graficos.drawImage(controle.getJogador3().getPeca1().getImage(), controle.getJogador3().getPeca1().getXSpawn(), controle.getJogador3().getPeca1().getYSpawn(), this);
	        graficos.drawImage(controle.getJogador3().getPeca2().getImage(), controle.getJogador3().getPeca2().getXSpawn(), controle.getJogador3().getPeca2().getYSpawn(), this);
	        graficos.drawImage(controle.getJogador3().getPeca3().getImage(), controle.getJogador3().getPeca3().getXSpawn(), controle.getJogador3().getPeca3().getYSpawn(), this);
	        graficos.drawImage(controle.getJogador3().getPeca4().getImage(), controle.getJogador3().getPeca4().getXSpawn(), controle.getJogador3().getPeca4().getYSpawn(), this);
        }
        
        if(controle.getJogador4() != null) {
	        graficos.drawImage(controle.getJogador4().getPeca1().getImage(), controle.getJogador4().getPeca1().getXSpawn(), controle.getJogador4().getPeca1().getYSpawn(), this);
	        graficos.drawImage(controle.getJogador4().getPeca2().getImage(), controle.getJogador4().getPeca2().getXSpawn(), controle.getJogador4().getPeca2().getYSpawn(), this);
	        graficos.drawImage(controle.getJogador4().getPeca3().getImage(), controle.getJogador4().getPeca3().getXSpawn(), controle.getJogador4().getPeca3().getYSpawn(), this);
	        graficos.drawImage(controle.getJogador4().getPeca4().getImage(), controle.getJogador4().getPeca4().getXSpawn(), controle.getJogador4().getPeca4().getYSpawn(), this);
        }

        if(controle.getTabuleiro().getNumDado() == 0) {
            graficos.drawImage(dado1, -2000, -2000, this); //posicao qualquer so pra tirar de dentro da tela
        } else if(controle.getTabuleiro().getNumDado() == 1) {
            graficos.drawImage(dado1, 10, 10, this);
        } else if(controle.getTabuleiro().getNumDado() == 2) {
            graficos.drawImage(dado2, 10, 10, this);
        } else if(controle.getTabuleiro().getNumDado() == 3) {
            graficos.drawImage(dado3, 10, 10, this);
        } else if(controle.getTabuleiro().getNumDado() == 4) {
            graficos.drawImage(dado4, 10, 10, this);
        } else if(controle.getTabuleiro().getNumDado() == 5) {
            graficos.drawImage(dado5, 10, 10, this);
        } else if(controle.getTabuleiro().getNumDado() == 6) {
            graficos.drawImage(dado6, 10, 10, this);
        }

	    g.dispose();
    }

}
