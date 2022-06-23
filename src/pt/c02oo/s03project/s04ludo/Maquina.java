package pt.c02oo.s03project.s04ludo;
import java.util.ArrayList;

public class Maquina extends Jogador{
	ArrayList<Peca> pecasDisponiveis;
    ArrayList<Peca> pecasBase;
	protected int qtdPecasDisponiveis;
	protected int qtdPecasBase;

	public Maquina(String cor, Tabuleiro tabuleiro) {
		super(cor, tabuleiro);
		
		//listinha com as pecas disponiveis e as da base
		ArrayList<Peca> pecasDisponiveis = new ArrayList();
        ArrayList<Peca> pecasBase = new ArrayList();
		qtdPecasBase = 0;
		qtdPecasDisponiveis = 0;
	}

	public void fazerJogada(int numDado) { //todas as maquinas vao precisar saber que pecas estao disponiveis e quais estao na base

        if (peca1.getEstaNaBase() == false) {
            pecasDisponiveis.add(peca1);
            qtdPecasDisponiveis++;
        }
        else{
            pecasBase.add(peca1);
            qtdPecasBase++;
        }
        if (peca2.getEstaNaBase() == false) {
            pecasDisponiveis.add(peca2);
            qtdPecasDisponiveis++;
        }
        else{
            pecasBase.add(peca2);
            qtdPecasBase++;
        }
        if (peca3.getEstaNaBase() == false) {
            pecasDisponiveis.add(peca3);
            qtdPecasDisponiveis++;
        }
        else{
            pecasBase.add(peca3);
            qtdPecasBase++;
        }
        if (peca4.getEstaNaBase() == false) {
            pecasDisponiveis.add(peca4);
            qtdPecasDisponiveis++;
        }
        else{
            pecasBase.add(peca4);
            qtdPecasBase++;
        }
        
    }
}
