import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingGameTest {

    BowlingGame bowlingGame;

    @BeforeEach
    void setUp(){
        bowlingGame = new BowlingGame();
    }

    @Test
    void shouldTransferInputStringToIntArray() throws Exception {
        String pinsDownInALine1 = "";
        assertThrows(Exception.class, () -> {
            bowlingGame.inputTransfer(pinsDownInALine1);
        });
        String pinsDownInALine2 = "a";
        assertThrows(Exception.class, () -> {
            bowlingGame.inputTransfer(pinsDownInALine2);
        });
        String pinsDownInALine3 = "/";
        int[] excepted3 = {0};
        assertEquals(Arrays.equals(excepted3, bowlingGame.inputTransfer(pinsDownInALine3)), true);
    }

}
