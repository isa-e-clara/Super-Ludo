package pt.c02oo.s03project.s04ludo;
import javax.swing.JOptionPane;

public class OpcaoVaziaBotException extends OpcaoVaziaException{

    public OpcaoVaziaBotException() {
        String[] options = {"vamos la!"};
        JOptionPane.showOptionDialog(null, "Por favor, selecione o bot contra qual deseja jogar.", "ERRO ", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
    }
    
}
