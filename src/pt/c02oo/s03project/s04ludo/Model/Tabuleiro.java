package pt.c02oo.s03project.s04ludo.Model;
import java.util.Random;

import pt.c02oo.s03project.s04ludo.Model.Celulas.Celula;
import pt.c02oo.s03project.s04ludo.Model.Celulas.CelulaFactory;
import pt.c02oo.s03project.s04ludo.View.ViewGrafico;

public class Tabuleiro {
	private Celula[][] celulas;
	private ViewGrafico view;
	private int numDado; 
	private static final Tabuleiro instance = new Tabuleiro();

	private Tabuleiro() {
		numDado = 0; //se for 0 significa q ainda n comecou
		celulas = new Celula[15][15];

		for(int i = 0; i < 15; i++)
			for(int j = 0; j < 15; j++) 
				celulas[i][j] = CelulaFactory.criarCelula(i, j); //criando as celulas adequadas para cada parte do tabuleiro			
	}
	
	
	public static Tabuleiro getInstance() {
		return instance;
	}

	public Celula getCelula(int x, int y) {
		return celulas[x][y];
	}

	public void conectaView(ViewGrafico view) {
		this.view = view;
	}

	public ViewGrafico getView() {
		return view;
	}

	public Celula getCelulaChegada (Peca peca, int numDado) { //qual celula a peca ira chegar andando a partir de determinado numDado
		Celula celulaProvisoria = null, celulaChegada = celulas[peca.getX()][peca.getY()];
		boolean ehDupla = false;
		for (int i = 0; i < numDado; i++) {
			if (celulaChegada != null) {
				if (celulaChegada.getProxX() == -1 && celulaChegada.getProxY() == -1) {
					peca.defineProxima(celulaChegada.getX(), celulaChegada.getY());
					ehDupla = true;
					celulaProvisoria = celulaChegada;
				}
				if (celulaChegada.getProxX() >= 0 && celulaChegada.getProxY() >= 0) 
					celulaChegada = celulas[celulaChegada.getProxX()][celulaChegada.getProxY()];
				else if (celulaChegada.getProxX() != -3 && celulaChegada.getProxY() != -3) //significa que a peça com certeza vai estar no caminho que só ela pode, então ela sempre vai poder mover para lá
					return null;
			}
			if (ehDupla == true){
				celulaProvisoria.setProximaX(-1);
				celulaProvisoria.setProximaY(-1);
				ehDupla = false;

			}
		}
		return celulaChegada;
	}
	
	public void come (int x, int y) {
		while (celulas[x][y].retornaPeca() != null) {
			Peca pecaComida = celulas[x][y].retornaPeca();
			celulas[x][y].desconectaPeca(pecaComida);
			celulas[pecaComida.getBaseX()][pecaComida.getBaseY()].conectaPeca(pecaComida); //voltando a peca comida para a base dela
			pecaComida.setX(pecaComida.getBaseX());
			pecaComida.setY(pecaComida.getBaseY());
			atualizarView(pecaComida, pecaComida.getBaseX(),pecaComida.getBaseY()); 
		}		
	}

	public void moverPeca(Peca peca, int numDado) {
		boolean ehDupla = false;
		Peca pecaAnterior = null;
		int xAnterior = -1;
		int yAnterior = -1;
		boolean podeDesconectar = false;

		for (int i = 0; i < numDado; i++) {
			int x = peca.getX();
			int y = peca.getY();

			if(xAnterior != -1 && yAnterior != -1) { //caso da celula que tinha peca que foi sobreposta
				celulas[xAnterior][yAnterior].conectaPeca(pecaAnterior);
			}

			if (celulas[x][y] != null) {

				if(celulas[x][y].getProxX() == -1 && celulas[x][y].getProxY() == -1) { //casinha dupla
					peca.defineProxima(x, y);
					ehDupla = true;
				}
				
				atualizarView(peca, celulas[x][y].getProxX(), celulas[x][y].getProxY()); 

				if (celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()] != null) { //sera null quando a peça ja tiver ganhado
					String cor = celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()].getCorPeca();
					if(cor != peca.getCor() && cor != "") { //celula com peca de cor diferente
						if(i == numDado - 1) //i == numDado - 1 eh pra checar se eh a ultima andada
							come(celulas[x][y].getProxX(),celulas[x][y].getProxY());	
						else if(celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()].pecaNumero(peca.getNumero()) != null){ //quando vai passar por cima de outra peca de mesmo numero
							xAnterior = celulas[x][y].getProxX();
							yAnterior = celulas[x][y].getProxY();
							pecaAnterior = celulas[xAnterior][yAnterior].pecaNumero(peca.getNumero()); //guardando referencia para a peca que estava la antes
							podeDesconectar = true;
						}
					}

					//desconectando a peca da celula antiga e conectando na nova
					celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()].conectaPeca(peca);
					if(xAnterior != -1 && yAnterior != -1 && (! podeDesconectar)) {
						xAnterior = -1;
						yAnterior = -1;
						podeDesconectar = true;
					} else {
						celulas[x][y].desconectaPeca(peca);
						podeDesconectar = false;
					}
				}
				
				//alterando o x e y da peca para o da nova posicao
				peca.setX(celulas[x][y].getProxX());
				peca.setY(celulas[x][y].getProxY());

				if(ehDupla == true) { //se era uma celula com duas opcoes de caminho
					celulas[x][y].setProximaX(-1); //voltando a referencia -1 para representar que eh uma celula com duas opcoes de caminho
					celulas[x][y].setProximaY(-1);
					ehDupla = false;
				}
			}		
			
			//verificando se chegou na celula final (ganhou):
			if((peca.getX() == 7 && peca.getY() == 6) || (peca.getX() == 6 && peca.getY() == 7) || (peca.getX() == 7 && peca.getY() == 8) || (peca.getX() == 8 && peca.getY() == 7)) {
				peca.setGanhou(true);
				break;
			}
		
		}
	}
	
	public int dado() {
		Random rand = new Random();
		int randomNum = rand.nextInt(6) + 1;
		this.numDado = randomNum;
		atualizarView(); 
		return randomNum; 
	}

	public int getNumDado() {
		return numDado;
	}
	
	public void atualizarView() { 
		//funcao para atualizar o view do dado qnd mudar o numero 
		view.updateUI();
	}
	
	public void atualizarView(Peca peca, int x, int y) {
		//funcao para atualizar o view qnd acontecer algum movimento da peca
		peca.update(x, y);
	}
	
	public void conectaPecaCelula(int x, int y, Peca peca) {
		celulas[x][y].conectaPeca(peca);
	}	
	
}