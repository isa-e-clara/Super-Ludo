package pt.c02oo.s03project.s04ludo.Exceptions;
import javax.swing.JOptionPane;

public class OpcaoVaziaBotException extends OpcaoVaziaException{

    public OpcaoVaziaBotException() {
        String[] options = {"Vamos la!", "Fechar jogo"};
        int i = JOptionPane.showOptionDialog(null, "Por favor, selecione o bot contra qual deseja jogar.", "ERRO ", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if(i == 1)
            System.exit(0);   
    }
    
}
