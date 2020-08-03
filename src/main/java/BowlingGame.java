public class BowlingGame {

    private final int bowlingGameScoreRecordNumber = 21;
    private final int maxScoreOfOneThrow = 10;
    private final int minScoreOfOneThrow = 0;

    int calculateTotalScore(int[] bowlingGameScoreRecord) {
        if (bowlingGameScoreRecordCheck(bowlingGameScoreRecord) == false)
            throw new RuntimeException("There is something error with bowling game score record!");
        return 0;
    }

    boolean bowlingGameScoreRecordCheck(int[] bowlingGameScoreRecord){
        if (bowlingGameScoreRecord.length != bowlingGameScoreRecordNumber) return false;
        for (int bowlingGameScore:bowlingGameScoreRecord){
            if (bowlingGameScore>maxScoreOfOneThrow || bowlingGameScore<minScoreOfOneThrow) return false;
        }
        return true;
    }
}
