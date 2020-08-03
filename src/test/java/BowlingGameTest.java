import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {

    BowlingGame bowlingGame = new BowlingGame();

    @Test
    void should_throw_exception_when_the_length_of_input_array_is_not_21() {
        // int[] bowlingGameScoreRecord = {};
        String bowlingGameScoreRecord = "";
        assertThrows(RuntimeException.class, () -> {
            bowlingGame.calculateTotalScore(bowlingGameScoreRecord);
        });
    }

    @Test
    void should_throw_exception_when_any_game_score_record_is_larger_than_10_or_negative() {
        // int[] bowlingGameScoreRecord1 = {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 11, 0, 0};
        // int[] bowlingGameScoreRecord2 = {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, -1, 0, 0};
        String bowlingGameScoreRecord1 = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 11, 0, 0";
        String bowlingGameScoreRecord2 = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, -1, 0, 0";
        String[] bowlingGameScoreRecordList = {bowlingGameScoreRecord1, bowlingGameScoreRecord2};
        for (String bowlingGameScoreRecord : bowlingGameScoreRecordList) {
            assertThrows(RuntimeException.class, () -> {
                bowlingGame.calculateTotalScore(bowlingGameScoreRecord);
            });
        }
    }

    @Test
    void should_throw_exception_when_hit_more_than_ten_pins_in_a_frame_expect_frame_ten() {
        // int[] bowlingGameScoreRecord1 = {10, 1, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 0};
        // int[] bowlingGameScoreRecord2 = {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10};
        String bowlingGameScoreRecord1 = "10, 1, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 0";
        String bowlingGameScoreRecord2 = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10";
        assertThrows(RuntimeException.class, () -> {
            bowlingGame.calculateTotalScore(bowlingGameScoreRecord1);
        });
        assertDoesNotThrow(() -> {
            bowlingGame.calculateTotalScore(bowlingGameScoreRecord2);
        });
    }

    @Test
    void should_throw_exception_when_does_not_spike_and_hit_more_than_ten_pins_in_final_frame_second_throw() {
        // int[] bowlingGameScoreRecord = {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 5, 6, 0};
        String bowlingGameScoreRecord = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 5, 6, 0";
        assertThrows(RuntimeException.class, () -> {
            bowlingGame.calculateTotalScore(bowlingGameScoreRecord);
        });
    }

    @Test
    void should_throw_exception_when_has_third_throw_in_final_frame_if_did_not_spike_or_spare() {
        // int[] bowlingGameScoreRecord = {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 5, 4, 1};
        String bowlingGameScoreRecord = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 5, 4, 1";
        assertThrows(RuntimeException.class, () -> {
            bowlingGame.calculateTotalScore(bowlingGameScoreRecord);
        });
    }

    @Test
    void should_calcate_the_correct_total_score() {
        // int[] bowlingGameScoreRecord = {5, 5, 10, 0, 10, 0, 5, 5, 8, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10};
        String bowlingGameScoreRecord = "5, 5, 10, 0, 10, 0, 5, 5, 8, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10";
        int exceptedScore = 241;
        assertEquals(exceptedScore, bowlingGame.calculateTotalScore(bowlingGameScoreRecord));
    }


}
