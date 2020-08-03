import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingGame {

    private final int maxThrowNumber = 21;
    private final int throwNumberExceptFinalFrame = 18;
    private final int throwNumberInOneFrameExceptionFinalFrame = 2;
    private final int maxScoreOfOneThrow = 10;
    private final int minScoreOfOneThrow = 0;

    int calculateTotalScore(String bowlingGameScoreRecord) {
        int[] bowlingGameScoreRecordArray = transferStringToArray(bowlingGameScoreRecord);
        return calculateTotalScore(bowlingGameScoreRecordArray);
    }

    private int[] transferStringToArray(String bowlingGameScoreRecord) {
        if (bowlingGameScoreRecord.length() == 0)
            throw new RuntimeException("There is something error with bowling game score record!");
        String[] scoreStringList = bowlingGameScoreRecord.split(",");
        List<Integer> scoreList = new ArrayList<>();
        try {
            for (String scoreString : scoreStringList) {
                if (scoreString.trim().equals("/")) scoreList.add(0);
                else scoreList.add(Integer.parseInt(scoreString.trim()));
            }
        } catch (Exception e) {
            throw new RuntimeException("There is something error with bowling game score record!");
        }
        return scoreList.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int calculateTotalScore(int[] bowlingGameScoreRecord) {
        if (bowlingGameScoreRecordCheck(bowlingGameScoreRecord) == false)
            throw new RuntimeException("There is something error with bowling game score record!");
        int totalScore = 0;
        int index = 0;
        while (index < throwNumberExceptFinalFrame) {
            totalScore += bowlingGameScoreRecord[index] + bowlingGameScoreRecord[index + 1];
            if (bowlingGameScoreRecord[index] == 10) {
                totalScore += calculateScoreWhenSpike(bowlingGameScoreRecord, index);
            } else if (bowlingGameScoreRecord[index] + bowlingGameScoreRecord[index + 1] == 10) {
                totalScore += bowlingGameScoreRecord[index + 2];
            }
            index += throwNumberInOneFrameExceptionFinalFrame;
        }
        totalScore += bowlingGameScoreRecord[throwNumberExceptFinalFrame] + bowlingGameScoreRecord[throwNumberExceptFinalFrame + 1] + bowlingGameScoreRecord[throwNumberExceptFinalFrame + 2];
        return totalScore;
    }

    private int calculateScoreWhenSpike(int[] bowlingGameScoreRecord, int index) {
        int result = bowlingGameScoreRecord[index + throwNumberInOneFrameExceptionFinalFrame];
        if (index != throwNumberExceptFinalFrame - throwNumberInOneFrameExceptionFinalFrame)
            result += bowlingGameScoreRecord[index + throwNumberInOneFrameExceptionFinalFrame] == 10 ? bowlingGameScoreRecord[index + throwNumberInOneFrameExceptionFinalFrame * 2] : bowlingGameScoreRecord[index + throwNumberInOneFrameExceptionFinalFrame + 1];
        else result += bowlingGameScoreRecord[index + throwNumberInOneFrameExceptionFinalFrame + 1];
        return result;
    }

    private boolean bowlingGameScoreRecordCheck(int[] bowlingGameScoreRecord) {
        if (bowlingGameScoreRecord.length != maxThrowNumber)
            return false;
        for (int index = 0; index < throwNumberExceptFinalFrame / throwNumberInOneFrameExceptionFinalFrame; index++) {
            if (bowlingGameScoreRecord[index * throwNumberInOneFrameExceptionFinalFrame] + bowlingGameScoreRecord[index * throwNumberInOneFrameExceptionFinalFrame + 1] > 10)
                return false;
        }
        for (int bowlingGameScore : bowlingGameScoreRecord) {
            if (bowlingGameScore > maxScoreOfOneThrow || bowlingGameScore < minScoreOfOneThrow)
                return false;
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
