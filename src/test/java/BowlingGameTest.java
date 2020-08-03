import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingGameTest {

    BowlingGame bowlingGame = new BowlingGame();

    @Test
    void should_throw_exception_when_the_length_of_input_array_is_not_21(){
        int[] bowlingGameScoreRecord = {};
        assertThrows(RuntimeException.class, () ->{
            bowlingGame.calculateTotalScore(bowlingGameScoreRecord);
        });
    }
}
