package pt.c02oo.s03project.s04ludo;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AppSuperLudo {
    public static void main (String args[]) {
        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        Controle controle = new Controle(tabuleiro);

        controle.definirQtdJogadores();;
        controle.criaJogadores();
        
        View view = new View(controle);
        new Frame(view);

        controle.conectaView(view);
        tabuleiro.conectaView(view);
        
        controle.iniciarJogo();
        
    }
}
