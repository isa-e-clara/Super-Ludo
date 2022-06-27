package pt.c02oo.s03project.s04ludo;
import javax.swing.JOptionPane;

public class OpcaoVaziaQtdJogadoresException extends OpcaoVaziaException{

    public OpcaoVaziaQtdJogadoresException() {
        String[] options = {"continuar"};
        JOptionPane.showOptionDialog(null, "Por favor, selecione a quantidade de jogadores para iniciar o jogo.", "ERRO ", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
    }
    
}
