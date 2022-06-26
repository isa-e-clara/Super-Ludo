package pt.c02oo.s03project.s04ludo;
import javax.swing.JFrame;

public class Container extends JFrame{

    public Container(Controle controle, View view) {
        add(view);
        setTitle("Super Ludo");
        setSize(720,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);

    }

    public static void main (String args[]) {
        Tabuleiro tabuleiro = new Tabuleiro();
        Controle controle = new Controle(tabuleiro);
        controle.setQtdJogadores(4);
        controle.criaJogadores();
        
        View view = new View(controle);
        new Container(controle, view);

        controle.conectaView(view);
        tabuleiro.conectaView(view);
        
        controle.iniciarJogo();
        
    }
}
