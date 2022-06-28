package pt.c02oo.s03project.s04ludo.Interfaces;

import pt.c02oo.s03project.s04ludo.Model.Peca;

public interface IJogador {
    public void fazerJogada(int numDado);
    public void mover(Peca peca, int numDado);
}
