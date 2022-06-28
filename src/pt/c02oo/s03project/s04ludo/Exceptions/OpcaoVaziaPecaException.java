package pt.c02oo.s03project.s04ludo.Exceptions;
import javax.swing.JOptionPane;

public class OpcaoVaziaPecaException extends OpcaoVaziaException{

    public OpcaoVaziaPecaException() {
        String[] options = {"continuar", "fechar jogo"};
        int i = JOptionPane.showOptionDialog(null, "Escolha alguma peca para mover!", "ERRO ", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if(i == 1)
            System.exit(0);
    }
    
}
