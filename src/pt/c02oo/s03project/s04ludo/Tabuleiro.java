package pt.c02oo.s03project.s04ludo;
import java.awt.Graphics2D;
import java.util.Random;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tabuleiro {
	private Celula[][] celulas;
	private View view;
	private Graphics2D grafico; //tirar
	private int numDado; //se for 0 significa q ainda n comecou
	private static final Tabuleiro instance = new Tabuleiro();

	private Tabuleiro() {
		numDado = 0;

		celulas = new Celula[15][15];
		for(int i = 0; i < 15; i++)
			for(int j = 0; j < 15; j++) 
				celulas[i][j] = CelulaFactory.criarCelula(i, j);			
	}
	
	
	public static Tabuleiro getInstance() {
		return instance;
	}

	public Celula getCelula( int x, int y) {
		return celulas[x][y];
	}

	public void conectaView(View view) {
		this.view = view;
	}

	public View getView() {
		return view;
	}
	
	public void conectaGrafico(Graphics2D graficos) {
		this.grafico = graficos;
	}
	
	public Graphics2D getGrafico() {
		return grafico;
	}

	public Celula getCelulaChegada (Peca peca, int numDado) {
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
			celulas[pecaComida.getBaseX()][pecaComida.getBaseY()].conectaPeca(pecaComida);
			pecaComida.setX(pecaComida.getBaseX());
			pecaComida.setY(pecaComida.getBaseY());
			atualizarView(pecaComida, pecaComida.getBaseX(),pecaComida.getBaseY()); //eh aqui mesmo??
		}		
	}

	public void moverPeca(Peca peca, int numDado) {
		//vamos ignorar a barreira
		//checar se pode mover vai ser la no fazer jogada
		boolean ehDupla = false;

		for (int i = 0; i < numDado; i++) {

			int x = peca.getX();
			int y = peca.getY();

			if (celulas[x][y] != null) {

				if(celulas[x][y].getProxX() == -1 && celulas[x][y].getProxY() == -1) { //casinha dupla
					peca.defineProxima(x, y);
					ehDupla = true;
				}
				
				atualizarView(peca, celulas[x][y].getProxX(), celulas[x][y].getProxY()); //eh aqui mesmo??

				if (celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()] != null) { //s´será null quando a peça já tiver ganhado
					//esse i == numDado - 1 eh pra checar se eh a ultima andada
					if (i == numDado - 1 && (celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()].getCorPeca() != peca.getCor()) && (celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()].getCorPeca() != "") ) { //vai comer
						come(celulas[x][y].getProxX(),celulas[x][y].getProxY());	
					}
	
					//celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()].desconectaPeca(peca);
					//desconectando a peca da celula antiga e conectando na nova
				
					celulas[celulas[x][y].getProxX()][celulas[x][y].getProxY()].conectaPeca(peca);
					celulas[x][y].desconectaPeca(peca);
				}
				

				//alterando o x e y da peca para o da nova posicao

				peca.setX(celulas[x][y].getProxX());
				peca.setY(celulas[x][y].getProxY());

				if(ehDupla == true) { //se era uma celula com duas opcoes de caminho
					celulas[x][y].setProximaX(-1);
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
		return randomNum; //precisa?
	}

	public int getNumDado() {
		return numDado;
	}
	
	//sobrecarga:
	public void atualizarView() { //numDado eh o numero q foi tirado no dado
		//funcao para atualizar o view do dado qnd mudar o numero ou algo do tipo
		view.updateUI();
	}
	
	public void atualizarView(Peca peca, int x, int y) {
		//funcao para atualizar o view qnd acontecer algum movimento
		peca.update(x, y);
	}
	
	public void conectaPecaCelula(int x, int y, Peca peca) {
		celulas[x][y].conectaPeca(peca);
	}
	
	
}