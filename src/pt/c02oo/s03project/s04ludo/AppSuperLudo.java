package pt.c02oo.s03project.s04ludo;

import pt.c02oo.s03project.s04ludo.Control.Controle;
import pt.c02oo.s03project.s04ludo.Model.Tabuleiro;
import pt.c02oo.s03project.s04ludo.View.Frame;
import pt.c02oo.s03project.s04ludo.View.ViewGrafico;

public class AppSuperLudo {
    public static void main (String args[]) {
        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        Controle controle = new Controle(tabuleiro);
        ViewGrafico view = new ViewGrafico(controle);
        
        tabuleiro.conectaView(view);
        controle.definirQtdJogadores();;
        controle.criaJogadores();
        
        new Frame(view);

        controle.iniciarJogo();
        
    }
}
