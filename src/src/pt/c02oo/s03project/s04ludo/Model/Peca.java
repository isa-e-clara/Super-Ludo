package pt.c02oo.s03project.s04ludo.Model;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import pt.c02oo.s03project.s04ludo.Interfaces.*;

public class Peca extends JPanel implements Observed{
	private int numero;
	private int x, y;
	private Tabuleiro tabuleiro;
	private String cor;
	private int baseX;
	private int baseY;
	private boolean ganhou;
	private Image imagem;
	private int xSpawn, ySpawn;
	private ArrayList<Observer> observers;
	
	
	public Peca(int x, int y, int numero, String cor) {
		this.x = x;
		this.y = y;
		this.numero = numero;
		this.cor = cor;
		this.baseX = x;
		this.baseY = y;
		this.ganhou = false;
		xSpawn = 48*(baseY);
		ySpawn = 48*(baseX) - 50;
		this.observers = new ArrayList<>();
		load();
	}
	
	public void load() {
		ImageIcon referencia;
		if (cor == "vermelho"){
			if (numero == 1)
				referencia = new ImageIcon("assets\\peca1vermelha.png");
			else if (numero == 2)
				referencia = new ImageIcon("assets\\peca2vermelha.png");
			else if (numero == 3)
				referencia = new ImageIcon("assets\\peca3vermelha.png");
			else 
				referencia = new ImageIcon("assets\\peca4vermelha.png");
		}
		else if (cor == "azul"){
			if (numero == 1)
				referencia = new ImageIcon("assets\\peca1azul.png");
			else if (numero == 2)
				referencia = new ImageIcon("assets\\peca2azul.png");
			else if (numero == 3)
				referencia = new ImageIcon("assets\\peca3azul.png");
			else 
				referencia = new ImageIcon("assets\\peca4azul.png");
		}
		else if (cor == "verde") {
			if (numero == 1)
				referencia = new ImageIcon("assets\\peca1verde.png");
			else if (numero == 2)
				referencia = new ImageIcon("assets\\peca2verde.png");
			else if (numero == 3)
				referencia = new ImageIcon("assets\\peca3verde.png");
			else 
				referencia = new ImageIcon("assets\\peca4verde.png");
		}
		else{
			if (numero == 1)
				referencia = new ImageIcon("assets\\peca1amarela.png");
			else if (numero == 2)
				referencia = new ImageIcon("assets\\peca2amarela.png");
			else if (numero == 3)
				referencia = new ImageIcon("assets\\peca3amarela.png");
			else 
				referencia = new ImageIcon("assets\\peca4amarela.png");
		}
		imagem = referencia.getImage();
	}

	public void update(int dy, int dx) {
		xSpawn = dx*48; 
		ySpawn = dy*48 - 50;
		notificarObservadores();
	}

	public void registrar(Observer obj) {
		if(!observers.contains(obj)) observers.add(obj);
	}

	public void notificarObservadores() {
		for (Observer obj : this.observers) {
			obj.update();
		}
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public Image getImage() {
		return imagem;
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

	public void conectaTabuleiro(Tabuleiro tabuleiro2) {
		this.tabuleiro = tabuleiro2;
		registrar(tabuleiro2.getView());
	}

	public String getCor() {
		return cor;
	}

	public void defineProxima(int x, int y) { //define as proximas posicoes para as pecas que estao em casas com duas possiveis proximas
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
			if (cor == "amarelo") 
				tabuleiro.getCelula(14,7).definirProxima(13,7);
			else
				tabuleiro.getCelula(14,7).definirProxima(14,6);
		}	
	}
	
}