package pt.c02oo.s03project.s04ludo.Model.Maquinas;
import java.util.Random;

import pt.c02oo.s03project.s04ludo.Model.Tabuleiro;

public class MaquinaAleatoria extends Maquina{

    public MaquinaAleatoria(String cor, Tabuleiro tabuleiro) {
		super(cor, tabuleiro);
	}

    public void fazerJogada(int numDado) {
        super.fazerJogada(numDado);
        
        Random rand = new Random();

        if (qtdPecasDisponiveis != 0) {
            int pecaDisponivelMovida = rand.nextInt(qtdPecasDisponiveis);

            if ((numDado == 1 || numDado == 6) && qtdPecasDisponiveis < 4) {
                int tirarDaBase = rand.nextInt(2);
                if (tirarDaBase == 0)
                    mover(pecasDisponiveis.get(pecaDisponivelMovida), numDado);
                else if(pecasBase.size() > 0){
                    mover(pecasBase.get(0), numDado);
                }
            }
            else {
                mover(pecasDisponiveis.get(pecaDisponivelMovida), numDado);
            }
        }
        else if (numDado == 1 || numDado == 6) {
            mover(peca1, numDado);
        }
        
    }
 
    
}
