# Compilação

O projeto utiliza o openjdk 17 ou superior, e já possui um arquivo .iml que pode ser usado por IDEs modernas 
(durante o desenvolvimento foi utilizado Intellij CE) para ajudar na compilação e execução do projeto. 
Mas caso deseje fazer a compilação de forma independente, é necessário adicionar o caminho para o JGroups durante 
a compilação e execução. As classes necessárias para rodar o projeto são `Main.java`, `GameController.java` e `Card.java`,
além do já citado arquivo `.jar` do JGroups.

# Execução

Os testes foram realizados com múltiplas instâncias do projeto rodando na mesma máquina. Ao iniciar uma instância, será
criado um cluster com o identificador "blackjack" na rede, e o processo que iniciou será o coordenador do projeto. As
próximas instâncias iniciadas irão conectar neste mesmo canal "blackjack".

# Funcionamento do jogo

O jogo possui uma interface simples de command line, possuindo 3 comandos principais que podem ser utilizados pelo dono
do turno atual. O número do comando deve sempre ser digitado pelo stdin da instância executada (normalmente o terminal).

| Número | Comando        |
|--------|----------------|
| 1      | Comprar carta  |
| 2      | Passar turno   |
| 3      | Sair do jogo   |

Os jogadores vão jogando por ordem de entrada no canal, e podem ir comprando cartas até atingirem 21 ou mais de pontuação.
Caso atinja exatamente 21, o jogador é declarado o vencedor instantâneamente. Caso passe de 21, o turno dele é encerrado
automaticamente, passando a vez para o próximo jogador. O jogador também pode passar a qualquer momento antes de atingir
21, utilizando o comando 2.

Quando todos os jogadores tiverem terminado seus turnos, a aplicação calcula o vencedor (ou mais de um, em caso de empate)
e transmite a mensagem para todos os ouvintes do canal.