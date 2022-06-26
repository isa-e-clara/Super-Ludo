package pt.c02oo.s03project.s04ludo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Peca extends JPanel{
	private int numero;
	private int x, y;
	private Tabuleiro tabuleiro;
	private String cor;
	private int baseX;
	private int baseY;
	private boolean ganhou;
	private Image imagem;
	private int xSpawn, ySpawn, altura, largura, dx, dy;
	
	
	public Peca(int x, int y, int numero, String cor) {
		this.x = x;
		this.y = y;
		this.numero = numero;
		this.cor = cor;
		this.baseX = x;
		this.baseY = y;
		this.ganhou = false;
		xSpawn = 48*(baseX);
		ySpawn = 48*(baseY);
		load();
	}
	
	public Image getImage() {
		return imagem;
	}
	
	public void load() {
		ImageIcon referencia;
		if (cor == "vermelho")
			referencia = new ImageIcon("res\\pecaVermelha.PNG");
		else if (cor == "azul")
			referencia = new ImageIcon("res\\pecaAzul.PNG");
		else if (cor == "verde") 
			referencia = new ImageIcon("res\\pecaVerde.PNG");
		else if (cor == "amarelo")
			referencia = new ImageIcon("res\\pecaAmarela.PNG");
		else //lembrar de consertar, tem q dar erro
			referencia = new ImageIcon("res\\pecaAmarela.PNG");
		imagem = referencia.getImage();

		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}

	public void update(int dy, int dx) {
		xSpawn = dx*48; //acho que eh sem o -24, pq no caso x=0 por ex, da negativo
		ySpawn = dy*48;
		tabuleiro.getView().updateUI();
		//validate();
		//repaint();
		//SwingUtilities.updateComponentTreeUI(this);
		//add(tabuleiro.getView());
		//Graphics2D graficos = (Graphics2D) java.awt.Graphics;
		//tabuleiro.getGrafico().drawImage(tabuleiro.getView().getFundo(), 0, 0, null);
		//Graphics graphics = new Graphics();
		//graphics.dispose();
	}


	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public int getXSpawn() {
		return xSpawn;
	}

	public int getYSpawn() {
		return ySpawn;
	}

	public boolean getGanhou() {
		return ganhou;
	}

	public void setGanhou(boolean ganhou) {
		this.ganhou = ganhou;
	}
	
	public int getBaseX() {
		return baseX;
	}

	public int getBaseY() {
		return baseY;
	}

	public int getNumero() {
		return numero;
	}
	
	public boolean getEstaNaBase() {
		if (x == baseX && y == baseY)
			return true;
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void conectaTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public String getCor() {
		return cor;
	}

	public void defineProxima() { //define as proximas posicoes para as pecas que estao em casas com duas poss�veis pr�ximas
		if (x == 7 && y == 0) {
			if (cor == "vermelho") 
				tabuleiro.getCelula(7, 0).definirProxima(7,1);
			else
				tabuleiro.getCelula(7, 0).definirProxima(6,0);
		}
		else if (x == 7 && y == 14) {
			if (cor == "azul") 
				tabuleiro.getCelula(7, 14).definirProxima(7,13);
			else
				tabuleiro.getCelula(7, 14).definirProxima(8,14);
		}
		else if (x == 0 && y == 7) {
			if (cor == "verde") 
				tabuleiro.getCelula(0,7).definirProxima(1,7);
			else
				tabuleiro.getCelula(0,7).definirProxima(0,8);
		}
		else if (x == 14 && y == 7) {
			if (cor == "verde") 
				tabuleiro.getCelula(14,7).definirProxima(13,7);
			else
				tabuleiro.getCelula(14,7).definirProxima(14,6);
		}	
	}
	

	
}