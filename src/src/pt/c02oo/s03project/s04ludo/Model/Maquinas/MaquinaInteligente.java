package pt.c02oo.s03project.s04ludo.Model.Maquinas;

import pt.c02oo.s03project.s04ludo.Model.Peca;
import pt.c02oo.s03project.s04ludo.Model.Tabuleiro;
import pt.c02oo.s03project.s04ludo.Model.Celulas.Celula;

public class MaquinaInteligente extends Maquina {

    public MaquinaInteligente(String cor, Tabuleiro tabuleiro) {
		super(cor, tabuleiro);
	}
    //não deixar peca dupla ser comida > 
    //comer alguem saindo da base (tirando 1) > 
    //comer alguem com uma peca q ja estava no tabuleiro > 
    //sair da base tirando 1> 
    //fugir com uma peça simples (diminuir alcance) > 
    //sair da base tirando 6 (ver alcance) > 
    //ir pra uma celula estrela > 
    //andar pecas na linha de chegada
    //empilhar peca
    //sortear uma peca aleatoria para andar

    //se existir peca empilhada, cuidar dessa pra nao perder duas pecas de uma vez
    public void fazerJogada(int numDado) { 
        super.fazerJogada(numDado);

        if (pecaEmpilhada() != null) { // prioridade maxima eh proteger peca dupla (perder duas pecas juntas eh muito negativo)
            //se for menos perseguida depois de andar (despistar inimigos)
            if (alcance(pecaEmpilhada(), tabuleiro.getCelula(pecaEmpilhada().getX(), pecaEmpilhada().getY())) > 0){
                if (alcance(pecaEmpilhada(), tabuleiro.getCelula(pecaEmpilhada().getX(), pecaEmpilhada().getY())) > alcance(pecaEmpilhada(), tabuleiro.getCelulaChegada(pecaEmpilhada(), numDado))) {
                    mover(pecaEmpilhada(), numDado);
                    return;
                }
            }
        }
        
        if (qtdPecasBase > 0 &&  numDado == 1) { //vamos ver se saindo da base, ele come alguma peca logo na primeira casa (casa segura)
            Peca peca = pecasBase.get(0);
            Celula celulaChegada = tabuleiro.getCelulaChegada(pecasBase.get(0), numDado);
            if (celulaChegada != null) {
                if (celulaChegada.getCorPeca() != peca.getCor() && celulaChegada.getCorPeca() != "") {
                    mover(peca, numDado);
                    return;
                }
            }
        }
         
        if (qtdPecasDisponiveis > 0) {
            for (int i = 0; i < qtdPecasDisponiveis; i++) { //ver se come alguma peca andando com qualquer peca

                Peca peca = pecasDisponiveis.get(i);
                Celula celulaChegada = tabuleiro.getCelulaChegada(peca, numDado);

                //ver se pode comer alguma peca andando com alguem
                if (celulaChegada != null) {
                    if (celulaChegada.getCorPeca() != peca.getCor() && celulaChegada.getCorPeca() != "" ) {
                        mover(peca, numDado); //se sim, comer
                        return;
                    }
                }
                //se n tiver ninguem pra comer ou correr imediatamente, andar pra ganahr no corredor
                //pecas do corredor vao ter anterior igual a -3 -3
            
            }
        }

        if (numDado == 1 && qtdPecasBase > 0) { //sair da base quando tirar 1
            mover (pecasBase.get(0), numDado);
            return;
        }

        Peca fujona = null;

        if (qtdPecasDisponiveis > 0) {
            for (int i = 0; i < qtdPecasDisponiveis; i++) { //fugir com a peca que consegue fugir mais com o numero sorteado
                Peca peca = pecasDisponiveis.get(i);
                int maisDespistamentos = 0;

                //se for menos perseguida depois de andar (despistar inimigos)
                if (alcance(peca, tabuleiro.getCelula(peca.getX(), peca.getY())) > 0 ) {
                    if (alcance(peca, tabuleiro.getCelula(peca.getX(), peca.getY())) > alcance(peca, tabuleiro.getCelulaChegada(peca, numDado))) {
                        if (alcance(peca, tabuleiro.getCelula(peca.getX(), peca.getY())) - alcance(peca, tabuleiro.getCelulaChegada(peca, numDado)) > maisDespistamentos) {
                            fujona = peca;
                            maisDespistamentos = alcance(peca, tabuleiro.getCelula(peca.getX(), peca.getY())) - alcance(peca, tabuleiro.getCelulaChegada(peca, numDado));
                        }
                    }
                }
            }
        }

        if (fujona != null) {
            mover(fujona, numDado);
            return;
        }

        if (numDado == 6 && qtdPecasBase > 0) { // sair da base tirando 6 se nao ficar na frente de um inimigo
            Peca peca = pecasBase.get(0);
            if (alcance(peca, tabuleiro.getCelulaChegada(peca, numDado)) == 0) {
                mover(peca, numDado);
                return;
            }
        }

        for (int i = 0; i < qtdPecasDisponiveis; i++) { //ver se alguma peca pode ir pra uma celula estrela

            Peca peca = pecasDisponiveis.get(i);
            Celula celulaChegada = tabuleiro.getCelulaChegada(peca, numDado);
            if (celulaChegada != null) {
                if (celulaChegada.getEhEstrela() == true) {
                    mover(peca, numDado);
                    return;
                }
            }
        }

        if (qtdPecasDisponiveis > 0) {
            for (int i = 0; i < qtdPecasDisponiveis; i++) { //ver se alguma peca pesta na linha de chegada

                Peca peca = pecasDisponiveis.get(i);
                
                //ve se esta na linha de chegada
                if (tabuleiro.getCelula(peca.getX(), peca.getY()).getXAnterior() == -3 && tabuleiro.getCelula(peca.getX(), peca.getY()).getYAnterior() == -3) {
                    mover(peca, numDado);
                    return;
                }
            }

            for (int i = 0; i < qtdPecasDisponiveis; i++) { //ver se alguma peca pode empilhar

                Peca peca = pecasDisponiveis.get(i);
                Celula celulaChegada = tabuleiro.getCelulaChegada(peca, numDado);

                //ve se celula de chegada tem outra peca da mesma cor
                if (celulaChegada != null) {
                    if (celulaChegada.getCorPeca() == peca.getCor()) {
                        mover(peca, numDado);
                        return;
                    }
                }
            }
        }   
        if (qtdPecasDisponiveis > 0) { //caso nao se encaixe em nenhuma condicao, andamos com uma peca qualquer
            mover(pecasDisponiveis.get(0), numDado);
            return;
        }

        if (numDado == 6 && qtdPecasBase > 0) {//caso tiremos 6 e tenham pecas na base, uma delas anda (nesse caso, ela tera inimigos a seguindo)
            mover(pecasBase.get(0), numDado);
            return;
        }
    

    }


    public Peca pecaEmpilhada() {
        if (qtdPecasDisponiveis == 0 || qtdPecasDisponiveis == 1) //impossivel ter peca empilhada quando so se tem 1 ou nenhuma peca no tabuleiro
            return null;
        else {
            for (int i = 0; i < qtdPecasDisponiveis -1 ; i++) {
                for (int j = i+1;j<qtdPecasDisponiveis;j++) {
                    if (pecasDisponiveis.get(i).getX() == pecasDisponiveis.get(j).getX() && pecasDisponiveis.get(i).getY() == pecasDisponiveis.get(j).getY()) {
                        return (pecasDisponiveis.get(i));
                    }
                }
            
            }
        }
        return null;
    }

    public int alcance(Peca peca, Celula celula) {
        Celula celulaAux = celula;
        int inimigosSeguindo = 0;
        if(celulaAux != null) {
            for (int i=0;i<6;i++) {

                if (celulaAux.getXAnterior() == -3 && celulaAux.getYAnterior() == -3) //esta na linha de chegada
                    return 0;

                celulaAux = tabuleiro.getCelula(celulaAux.getXAnterior(), celulaAux.getYAnterior());
                if (celulaAux.getCorPeca() != peca.getCor() && celulaAux.getCorPeca() != "") {
                    inimigosSeguindo++;
                }
            }
        }
        return inimigosSeguindo;
    }
}
