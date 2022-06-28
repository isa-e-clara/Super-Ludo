package pt.c02oo.s03project.s04ludo.Model.Celulas;

public class CelulaFactory {
    public static Celula criarCelula(int i, int j) {
        Celula celula;
        if(i >= 2 && i <= 3 && j >= 2 && j <= 3) {
            celula = new Base("vermelho", i, j);
            celula.definirProxima(6, 1);
        } else if(i >= 2 && i <= 3 && j >= 11 && j <= 12) {
            celula = new Base("verde", i, j);
            celula.definirProxima(1, 8);
        } else if(i >= 11 && i <= 12 && j >= 2 && j <= 3) {
            celula = new Base("amarelo", i, j);
            celula.definirProxima(13, 6);
        } else if(i >= 11 && i <= 12 && j >= 11 && j <= 12) {
            celula = new Base("azul", i, j);
            celula.definirProxima(8, 13);
        } else if(i == 6 && j == 12) {
            celula = new CelulaEstrela(i, j, "null");
            celula.definirProxima(6, 13); //prox normal
            celula.definirAnterior(6, 11);
        } else if(i == 6 && (j <= 5 || j >= 9)) {
            if (j == 1)
                celula = new CelulaEstrela(i, j, "vermelho");
            else
                celula = new Celula("null", i, j);
            if(j == 5)
                celula.definirProxima(5, 6);
            else if(j == 14)
                celula.definirProxima(7, 14);
            else
                celula.definirProxima(6, j + 1);
            if (j == 0)
                celula.definirAnterior(7, 0);
            else if (j == 9)
                celula.definirAnterior(5, 8);
            else
                celula.definirAnterior(6, j-1);
        } else if(i == 8 && j == 2) {
            celula = new CelulaEstrela(i, j, "null");
            celula.definirProxima(8, 1); //prox normal
            celula.definirAnterior(8, 3);
        } else if(i == 8 && (j <= 5 || j >= 9)) {
            if (j == 13)
                celula = new CelulaEstrela(i, j, "azul");
            else
                celula = new Celula("null", i, j);
            if(j == 0)
                celula.definirProxima(7, 0);
            else if(j == 9)
                celula.definirProxima(9, 8);
            else
                celula.definirProxima(8, j - 1);
            if (j == 5)
                celula.definirAnterior(9, 6);
            else if (j == 14)
                celula.definirAnterior(7, 14);
            else
                celula.definirAnterior(i, j+1);
        } else if(i == 2 && j == 6) {
            celula = new CelulaEstrela(i, j, "null");
            celula.definirProxima(1, 6); //prox normal
            celula.definirAnterior(3, 6);
        } else if(j == 6 && (i <= 5 || i >= 9)) {
            if (i == 13)
                celula = new CelulaEstrela(i, j, "amarelo");
            else
                celula = new Celula("null", i, j);
            if(i == 0)
                celula.definirProxima(0, 7);
            else if(i == 9)
                celula.definirProxima(8, 5);
            else
                celula.definirProxima(i - 1, 6);
            if (i == 5)
                celula.definirAnterior(6, 5);
            else if (i==14)
                celula.definirAnterior(14, 7);
            else
                celula.definirAnterior(i+1, j);
        } else if(i == 12 && j == 8) {
            celula = new CelulaEstrela(i, j, "null");
            celula.definirProxima(13, 8); //prox normal
            celula.definirAnterior(11, 8);
        } else if(j == 8 && (i <= 5 || i >= 9)) {
            if (i == 1)
                celula = new CelulaEstrela(i, j, "verde");
            else
                celula = new Celula("null", i, j);
            if(i == 5)
                celula.definirProxima(6, 9);
            else if(i == 14)
                celula.definirProxima(14, 7);
            else
                celula.definirProxima(i + 1, 8);
            if (i == 0)
                celula.definirAnterior(0, 7);
            else if (i == 9)
                celula.definirAnterior(8, 9);
            else
                celula.definirAnterior(i-1, j);
        } else if((i == 7 && j == 0) || (i == 0 && j == 7) || (i == 7 && j == 14) || (i == 14 && j == 7)) {
            celula = new Celula("null", i, j);
            celula.definirProxima(-1, -1); //a proxima posicao depende da cor de cada peca, fazer um if quando tiver movendo a peca para ver isso
            if (i == 7 && j == 0)
                celula.definirAnterior(8, 0);
            else if (i == 0 && j == 7)
                celula.definirAnterior(0,6);
            else if (i == 7 && j == 14)
                celula.definirAnterior(6, 14);
            else
                celula.definirAnterior(14, 8);
        } else if(i == 7 && j <= 5 && j > 0) {
            celula = new Celula("vermelho", i, j);
            celula.definirProxima(7, j + 1);
        } else if(j == 7 && i <= 5 && i > 0) {
            celula = new Celula("verde", i, j);
            celula.definirProxima(i + 1, 7);
        } else if(i == 7 && j >= 9 && j < 14) {
            celula = new Celula("azul", i, j);
            celula.definirProxima(7, j - 1);
        } else if(j == 7 && i >= 9 && i < 14) {
            celula = new Celula("amarelo", i, j);
            celula.definirProxima(i - 1, 7);
        } else {
            celula = null;
        }
        return celula;
    }
}