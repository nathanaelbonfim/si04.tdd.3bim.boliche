
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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

    @Test
    public void mustThrowExceptionWhenAddingPlayerWithDuplicateName() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
        boliche.newPlayer("Player 2");
        boliche.newPlayer("Player 3");

        assertThrows(RuntimeException.class, () -> {
            boliche.newPlayer("Player 1");
        });
    }

    @Test
    public void mustThrowExceptionWhenPlayerRollsBeforeGameStarts() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
        boliche.newPlayer("Player 2");
        boliche.newPlayer("Player 3");

        assertThrows(RuntimeException.class, () -> {
            boliche.roll("Player 1", 1);
        });
    }

    @Test
    public void mustThrowExceptionWhenPlayerRollsOutOfTurn() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
        boliche.newPlayer("Player 2");
        boliche.startGame();

        assertThrows(RuntimeException.class, () -> {
            boliche.roll("Player 2", 1);
        });
    }

    @Test
    public void mustThrowExceptionWhenPlayerRollsMoreThanMaxPins() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
        boliche.startGame();

        assertThrows(RuntimeException.class, () -> {
            boliche.roll("Player 1", 11);
        });

        assertThrows(RuntimeException.class, () -> {
            boliche.roll("Player 1", 5);
            boliche.roll("Player 1", 6);
        });
    }

    @Test
    public void mustCalculateScoreForSingleFrameSinglePlayer() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
        boliche.startGame();

        boliche.roll("Player 1", 5);
        boliche.roll("Player 1", 4);

        assertEquals(9, boliche.getScore("Player 1"));
    }

    @Test
    public void mustCalculateScoreForStrikeSinglePlayer() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
        boliche.startGame();

        boliche.roll("Player 1", 10);

        boliche.roll("Player 1", 4);
        boliche.roll("Player 1", 3);

        assertEquals(24, boliche.getScore("Player 1"));
    }

    @Test
    public void mustCalculateScoreForStrikeMultiplayer() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
        boliche.newPlayer("Player 2");
        boliche.startGame();

        boliche.roll("Player 1", 10);
        boliche.roll("Player 2", 10);

        boliche.roll("Player 1", 4);
        boliche.roll("Player 1", 3);

        boliche.roll("Player 2", 1);
        boliche.roll("Player 2", 9);

        assertEquals(24, boliche.getScore("Player 1"));
        assertEquals(30, boliche.getScore("Player 2"));
    }

    @Test
    public void mustCalculateScoreForSpareSinglePlayer() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
        boliche.startGame();

        boliche.roll("Player 1", 5);
        boliche.roll("Player 1", 5);

        boliche.roll("Player 1", 8);
        boliche.roll("Player 1", 1);

        assertEquals(27, boliche.getScore("Player 1"));
    }

    @Test
    public void mustCalculateScoreForSpareMultiplayer() {
        Boliche boliche = new Boliche();

        boliche.newPlayer("Player 1");
        boliche.newPlayer("Player 2");
        boliche.startGame();

        boliche.roll("Player 1", 2);
        boliche.roll("Player 1", 8);

        boliche.roll("Player 2", 5);
        boliche.roll("Player 2", 5);

        boliche.roll("Player 1", 1);
        boliche.roll("Player 1", 0);

        boliche.roll("Player 2", 9);
        boliche.roll("Player 2", 0);

        assertEquals(12, boliche.getScore("Player 1"));
        assertEquals(28, boliche.getScore("Player 2"));
    }
}
