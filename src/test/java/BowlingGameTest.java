import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {

    BowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
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

//    @Test
//    void shouldCheckTransferedIntArray() {
//        String pinsDownInALine0 = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0";
//        String pinsDownInALine1 = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 11, 0, 0";
//        String pinsDownInALine2 = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, -1, 0, 0";
//        String pinsDownInALine3 = "10, 1, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 0";
//        String pinsDownInALine4 = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 5, 6, 0";
//        String pinsDownInALine5 = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 5, 4, 1";
//        String pinsDownInALine6 = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10";
//        String[] bowlingGameScoreRecordList = {pinsDownInALine0, pinsDownInALine1, pinsDownInALine2, pinsDownInALine3
//                , pinsDownInALine4, pinsDownInALine5};
//        for (String bowlingGameScoreRecord : bowlingGameScoreRecordList) {
//            assertThrows(Exception.class, () -> {
//                bowlingGame.calculateTotalScore(bowlingGameScoreRecord);
//            });
//        }
//        assertDoesNotThrow(() -> {
//            bowlingGame.calculateTotalScore(pinsDownInALine6);
//        });
//    }
//
//    @Test
//    void shouldReturnCorrectTotalScore() throws Exception {
//        String pinsDownInALine0 = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10";
//        assertEquals(bowlingGame.calculateTotalScore(pinsDownInALine0),300);
//        String pinsDownInALine1 = "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
//        assertEquals(bowlingGame.calculateTotalScore(pinsDownInALine1),0);
//        String pinsDownInALine2 = "8, 2, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
//        assertEquals(bowlingGame.calculateTotalScore(pinsDownInALine2),20);
//        String pinsDownInALine3 = "6, 2, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
//        assertEquals(bowlingGame.calculateTotalScore(pinsDownInALine3),13);
//        String pinsDownInALine4 = "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3";
//        assertEquals(bowlingGame.calculateTotalScore(pinsDownInALine4),15);
//        String pinsDownInALine5 = "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 2, 3";
//        assertEquals(bowlingGame.calculateTotalScore(pinsDownInALine5),13);
//        String pinsDownInALine6 = "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 2, 0";
//        assertEquals(bowlingGame.calculateTotalScore(pinsDownInALine6),8);
//        String pinsDownInALine7 = "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 10, 2, 0";
//        assertEquals(bowlingGame.calculateTotalScore(pinsDownInALine7),32);
//    }

    @Test
    void shouldThrowExceptionWhenTheLengthOfTransferedIntArrayIncorrect(){
        String pinsDownInALine = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0";
        assertThrows(Exception.class, () -> {
                bowlingGame.calculateTotalScore(pinsDownInALine);
            });
    }

    @Test
    void shouldThrowExceptionWhenThePinsDownMoreThanTenInAThrow(){
        String pinsDownInALine = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 11, 0, 0";
        assertThrows(Exception.class, () -> {
            bowlingGame.calculateTotalScore(pinsDownInALine);
        });
    }

    @Test
    void shouldThrowExceptionWhenThePinsDownLessThanZeroInAThrow(){
        String pinsDownInALine = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, -1, 0, 0";
        assertThrows(Exception.class, () -> {
            bowlingGame.calculateTotalScore(pinsDownInALine);
        });
    }

    @Test
    void shouldThrowExceptionWhenThePinsDownNumberIncorrectBeforeFrameTen(){
        String pinsDownInALine = "10, 1, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 0";
        assertThrows(Exception.class, () -> {
            bowlingGame.calculateTotalScore(pinsDownInALine);
        });
    }

    @Test
    void shouldThrowExceptionWhenThePinsDownNumberMoreThanTenInFrameTenInSpareThrow(){
        String pinsDownInALine = "10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 5, 6, 0";
        assertThrows(Exception.class, () -> {
            bowlingGame.calculateTotalScore(pinsDownInALine);
        });
    }
}
