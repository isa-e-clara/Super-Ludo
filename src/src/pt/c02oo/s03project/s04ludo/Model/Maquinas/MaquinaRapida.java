package pt.c02oo.s03project.s04ludo.Model.Maquinas;

import pt.c02oo.s03project.s04ludo.Model.Tabuleiro;

public class MaquinaRapida extends Maquina{

    public MaquinaRapida(String cor, Tabuleiro tabuleiro) {
		super(cor, tabuleiro);
	}

    public void fazerJogada(int numDado) { 
        //coloca uma peca no tabuleiro e CORRE, só tira outra quando essa primeira for comida ou chegar no final
        super.fazerJogada(numDado);
        if (qtdPecasDisponiveis != 0) { //sempre vai ter uma ou zero pecas no tabuleiro
            mover(pecasDisponiveis.get(0), numDado);
        }
        else if (numDado == 1 || numDado == 6){
            mover(pecasBase.get(0), numDado);
        }
    }
}
