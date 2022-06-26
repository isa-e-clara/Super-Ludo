package pt.c02oo.s03project.s04ludo;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class View extends JPanel {
    private Image fundo;
    private Controle controle;

    public View(Controle controle) {
        this.controle = controle;
        ImageIcon referencia = new ImageIcon("res\\tabuleiro_novo.png");
        fundo = referencia.getImage();
    }

    public void conectaControle(Controle controle) {
        this.controle = controle;
    }

    public Image getFundo() {
		return fundo;
	}

	public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        controle.getTabuleiro().conectaGrafico(graficos); //tirar
        
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
	    g.dispose();
    }

    // @Override
    // public void actionPerformed(ActionEvent arg0) {
    //     controle.getJogador1().getPeca1().update(dx, dy);
    //     repaint();
    // }
}
