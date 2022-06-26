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

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        //aqui em baixo o jogador 1 eh nulo, ainda n foi inicializado
        graficos.drawImage(controle.getJogador1().getPeca1().getImage(), controle.getJogador1().getPeca1().getXSpawn(), controle.getJogador1().getPeca1().getYSpawn(), this);
        g.dispose();
    }

    // @Override
    // public void actionPerformed(ActionEvent arg0) {
    //     controle.getJogador1().getPeca1().update(dx, dy);
    //     repaint();
    // }
}
