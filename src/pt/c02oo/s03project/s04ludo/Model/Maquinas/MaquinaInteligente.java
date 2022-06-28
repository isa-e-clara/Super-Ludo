package pt.c02oo.s03project.s04ludo.Model.Maquinas;

import pt.c02oo.s03project.s04ludo.Model.Tabuleiro;

public class MaquinaInteligente extends Maquina {

    public MaquinaInteligente(String cor, Tabuleiro tabuleiro) {
		super(cor, tabuleiro);
	}

    public void fazerJogada(int numDado) { //estudar ludo e desenvolver a nossa estrategia kkkkkk

        //coisas principais q eu pensei:
            //quando for escolher uma peca pra andar, se alguma delas puder comer alguem, ir nessa
            //se tirar 1 ou 6, sempre tirar a peca da casinha se tiver
    			//acho que nao, por exemplo, se tiver uma peca com risco de ser comida andar 6 com ela, acho que vale mais a pena
            //fazer uma funcao que ve a distancia da peca mais proxima de vc pra tras e outra pra frente 
                //se tiver uma peca proxima atras, correr
                //se tiver uma peca proxima na frente, tentar nao ultrapassar (aumenta a chance de ser comido)
            //nao andar com peca que cairia numa casa onde tem pecas empilhadas
    			//pq nao?
            //se nao tiver nada de importante pra fazer (comer alguem ou fugir) e puder entrar com alguma peca em alguma celula estrela, ir (se proteger)

        //coisas menos fundamentais mas q seriam legais se desse pra por:
            //descobrir quando (e se) é benéfico empilhar pecas. talvez levar em conta aquela funcao q conta a pessoa masi proxima atras 

        
        //depois vou dar uma olhada na internet e ver se alguem explica estrategias pra ludo, deve ter
    }

}
