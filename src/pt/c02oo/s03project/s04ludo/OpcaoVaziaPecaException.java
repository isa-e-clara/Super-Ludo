package pt.c02oo.s03project.s04ludo;
import javax.swing.JOptionPane;

public class OpcaoVaziaPecaException extends OpcaoVaziaException{

    public OpcaoVaziaPecaException() {
        String[] options = {"continuar"};
        JOptionPane.showOptionDialog(null, "Escolha alguma peca para mover!", "ERRO ", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
    }
    
}
