package pt.c02oo.s03project.s04ludo;
import java.util.Random;

public class Jogador { //amiga achei melhor fazer por heranca pq só uma função vai ser
	//diferente pra máquina e pra pessoa
	private Peca peca1, peca2, peca3, peca4;
	
	public void conectaPeca(Peca peca) { 
		int numero = peca.getNumero();
		if(numero == 1)
			this.peca1 = peca;	
		else if(numero == 2)
			this.peca2 = peca;
		else if(numero == 3)
			this.peca3 = peca;
		else if(numero == 4)
			this.peca4 = peca;
		//else
			//erro, exception		
	}
	
	public int dado() {
		Random rand = new Random();
		int randomNum = rand.nextInt(6) + 1;
		return randomNum;
	}
	
	public void move() {} //aqui entra ou a estratégia da máquina ou a escolha de que peca vai andar da pessoa
	
	
}