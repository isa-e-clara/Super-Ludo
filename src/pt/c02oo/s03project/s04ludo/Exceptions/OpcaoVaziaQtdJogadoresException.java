package pt.c02oo.s03project.s04ludo.Exceptions;
import javax.swing.JOptionPane;

public class OpcaoVaziaQtdJogadoresException extends OpcaoVaziaException{

    public OpcaoVaziaQtdJogadoresException() {
        String[] options = {"Continuar", "Fechar jogo"};
        int i = JOptionPane.showOptionDialog(null, "Por favor, selecione a quantidade de jogadores para iniciar o jogo.", "ERRO ", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if(i == 1)
            System.exit(0);   
    }
    
}
