package pt.c02oo.s03project.s04ludo;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Container extends JFrame{

    public Container(Controle controle, View view) { //acho que pode tirar o controle ne?
        add(view);
        setTitle("Super Ludo");
        setSize(740,755);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);

    }

    public static void main (String args[]) {
        Tabuleiro tabuleiro = new Tabuleiro();
        Controle controle = new Controle(tabuleiro);

        controle.definirQtdJogadores();;
        controle.criaJogadores();
        
        View view = new View(controle);
        new Container(controle, view);

        controle.conectaView(view);
        tabuleiro.conectaView(view);
        
        controle.iniciarJogo();
        
    }
}
