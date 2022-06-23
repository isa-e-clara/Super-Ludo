package pt.c02oo.s03project.s04ludo;
import java.util.Random;

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
                    mover(pecasDisponiveis.get(pecaDisponivelMovida));
                else {
                    mover(pecasBase.get(0));
                }
            }
            else {
                mover(pecasDisponiveis.get(pecaDisponivelMovida));
            }
        }
        else if (numDado == 1 || numDado == 6) {
            mover(peca1);
        }
        
    }

    public void mover(Peca peca) {} 
    //amiga acho melhor a gente so mover a peca aqui, toda a estrategia ser no fazerJogada
    //pq ai essa mover fica igual p todos os jogadores (pessoa ou maquina), so move a peca (e ai implementa essa logo em jogador) 
    
}
