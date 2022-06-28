# Instruções

## Como instalar?
Pode-se baixar o arquivo executável e rodar na mesma pasta que a pasta assets (contém as imagens) ou pode-se baixar esta pasta (com os arquivos src, bin e assets) e rodar a main (AppSuperLudo.java) em alguma IDE de sua preferência.

## Como jogar?
O jogo é interativo e vão aparecendo janelas com perguntas para você selecionar a sua preferência. É bem simples, apenas clique com o mouse na opção desejada, que o jogo vai se configurando e atualizando. O mesmo é válido para movimentar as peças, basta escolher qual o número que deseja mover, lembrando que só aparecem como opção as peças que podem andar, de acordo com as regras. Caso alguém ganhe ou acabe o jogo, irá aparecer uma mensagem. Caso deseje sair, clique para fechar a janela, irá aparecer uma pergunta de confirmação, basta confirmar.

### Como funciona?
O objetivo é dar a volta no tabuleiro com todas suas 4 peças, movimentando-as de acordo com o número dos dados. A dificuldade encontra-se que se uma peça adversária cair na mesma célula que a sua, sua peça é comida e deve retornar a base, recomeçando todo o percurso. Analogamente, você também pode comer peças inimigas. Pode-se jogar com os amigos de 2, 3 ou 4 pessoas, ou também pode-se jogar contra algum dos bots (aleatório, rápido, inteligente). Ganha quem completar o objetivo primeiro.

### Regras
- Cada jogador tem 4 peças
- Cada jogador é representado por uma cor (vermelho, verde, azul ou amarelo)
- Pode haver até 4 jogadores
- A posição das cores no tabuleiro é sempre a mesma 
- Cada jogador, roda o dado, faz sua jogada (escolhe qual peça mover, dentre as possíveis), e então é a vez do próximo jogador
- Só pode retirar uma peça da base quando o dador der 1 ou 6;
- As peças se movimentam pelas células do tabuleiro, de acordo com o número dos dados, e podem comer peças adversárias ou serem comidas por estas
- Existem células estrelas no tabuleiro, as quais fornecem proteção
  - Se for uma célula estrela colorida, a peça de mesma cor que estiver nela não pode ser comida naquela célula
  - Se for uma célula estrela sem cor, a peça que estiver nela não pode ser comida naquela célula
  - Se tiver uma peça na célula estrela (e ela não puder ser comida), nenhuma outra peça de cor diferente conseguirá ir para aquela célula
-  Pode haver no máximo 4 peças da mesma cor em uma mesma célula
     - Quando peças de mesma cor caem na mesma célula, elas se unem, e a partir desse momento fazem todos os movimentos iguais, ou seja, andam juntas e morrem juntas
         - pode se empilhar de 2 à 4 peças de mesma cor
     - Quando uma peça cae em uma célula em que está outra peça, mas de cor diferente, ela a come (exceto quando é uma célula de proteção, como mencionado)
- Quando uma peça é comida ela volta para a base e deve recomeçar o percurso
- Também há células coloridas, que representam o caminho de chegada, nelas apenas a peça de mesma cor tem acesso, com isso, é um espaço seguro e não é possível a peça ser comida quando chega nessa parte do trajeto
- Ganha quem der a volta no tabuleiro com todas as 4 peças

### Sobre os bots...
Pode-se escolher competir contra um dos bots, são eles:

> Máquina aleatória: Faz juz ao nome. Escolhe peças e movimentos de forma aleatória.

> Máquina rápida: Nunca terá mais de uma peça no tabuleiro. Corre com sua peça até a vitória (ou a morte).

> Máquina inteligente: Incorpora uma estratégia de acordo com prioridades definidas.
