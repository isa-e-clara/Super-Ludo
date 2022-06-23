package pt.c02oo.s03project.s04ludo;

public class MaquinaRapida extends Maquina{

    public MaquinaRapida(String cor, Tabuleiro tabuleiro) {
		super(cor, tabuleiro);
	}

        //amiga sera q a gente oloca aquilo de so poder ganhar quando tirar exatamente o que precisa pra chegar no lugar final? 
        //pq vai ter q colocar isso em todas as maquinas e na pessoa... tava pensando em so andar mesmo e fds, por mim pode ser 
    public void fazerJogada(int numDado) { //sempre vai ter uma ou zero pecas no tabuleiro
        //coloca uma peca no tabuleiro e CORRE, só tira outra quando essa primeira for comida ou chegar no final
        if (qtdPecasDisponiveis != 0) {
            mover(pecasDisponiveis.get(0));
        }
        else if (numDado == 1 || numDado == 6){
            mover(pecasBase.get(0));
        }
    }
}
