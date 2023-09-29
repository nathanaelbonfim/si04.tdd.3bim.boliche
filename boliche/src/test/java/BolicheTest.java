

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.unipar.si.tdd.boliche.Boliche;

public class BolicheTest {
    // O software deve receber o nome de 3 jogadores, armazenar em variáveis
    // mesmo;
    @Test
    public void mustReceiveThreePlayersNameTest() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
        boliche.newPlayer("Player 2");
        boliche.newPlayer("Player 3");

        assertEquals(3, boliche.getPlayers().size());
    }

    // Após os nomes, o sw deverá iniciar o jogo solicitando o número de pinos derrubados nas duas jogadas do jogador da vez:
    @Test
    public void mustReceivePinsKnockedDownTest() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
    }
}
