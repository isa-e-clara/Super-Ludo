package pt.c02oo.s03project.s04ludo.Model.Celulas;

public class CelulaEstrela extends Celula{
	
	public CelulaEstrela(int x, int y, String cor) {
		super(cor, x, y); 
		super.ehEstrela = true;
	}
	
}
