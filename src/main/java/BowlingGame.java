public class BowlingGame {

    private final int maxThrowNumber = 21;
    private final int throwNumberExceptFinalFrame = 18;
    private final int throwNumberInOneFrameExceptionFinalFrame = 2;
    private final int maxScoreOfOneThrow = 10;
    private final int minScoreOfOneThrow = 0;

    int calculateTotalScore(int[] bowlingGameScoreRecord) {
        if (bowlingGameScoreRecordCheck(bowlingGameScoreRecord) == false)
            throw new RuntimeException("There is something error with bowling game score record!");
        return 0;
    }

    boolean bowlingGameScoreRecordCheck(int[] bowlingGameScoreRecord) {
        if (bowlingGameScoreRecord.length != maxThrowNumber) return false;
        for (int index = 0; index < throwNumberExceptFinalFrame / throwNumberInOneFrameExceptionFinalFrame; index++) {
            if (bowlingGameScoreRecord[index * throwNumberInOneFrameExceptionFinalFrame] + bowlingGameScoreRecord[index * throwNumberInOneFrameExceptionFinalFrame + 1] > 10)
                return false;
        }
        for (int bowlingGameScore : bowlingGameScoreRecord) {
            if (bowlingGameScore > maxScoreOfOneThrow || bowlingGameScore < minScoreOfOneThrow) return false;
        }
        for (int index = 0; index < throwNumberExceptFinalFrame / throwNumberInOneFrameExceptionFinalFrame; index++) {
            if (bowlingGameScoreRecord[index * throwNumberInOneFrameExceptionFinalFrame] + bowlingGameScoreRecord[index * throwNumberInOneFrameExceptionFinalFrame + 1] > 10)
                return false;
        }
        if (bowlingGameScoreRecord[throwNumberExceptFinalFrame] < 10 && bowlingGameScoreRecord[throwNumberExceptFinalFrame] + bowlingGameScoreRecord[throwNumberExceptFinalFrame + 1] > 10)
            return false;
        if (bowlingGameScoreRecord[throwNumberExceptFinalFrame] + bowlingGameScoreRecord[throwNumberExceptFinalFrame + 1] < 10 && bowlingGameScoreRecord[throwNumberExceptFinalFrame + 2] != 0)
            return false;
        return true;
    }
}
