package pt.c02oo.s03project.s04ludo;

public class CelulaEstrela extends Celula{
	
	public CelulaEstrela(int x, int y, String cor) {
		super(cor, x, y); //acho que a estrela n tem cor ne?
		//a cor pode ser null pras celulas estrelas normais, ou pode ter cor para as
		//células estrelas de saída de base
		super.ehEstrela = true;
	}
	
}
