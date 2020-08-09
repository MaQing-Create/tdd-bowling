import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingGame {

    private int totalThrowNumber = 21;
    private int maxPinsDownNumberInAThrow = 10;
    private int minPinsDownNumberInAThrow = 0;
    private int totalFrameNumber = 10;
    private int maxPinsDownNumberInAFrameBeforeFrameTen = 10;

    int[] inputTransfer(String pinsDownInALine) throws Exception {
        if (!isInputStringLegal(pinsDownInALine)) {
            throw new Exception("Input String formation is illegal!");
        }
        List<Integer> pinsDownInALineList = new ArrayList<>();
        Arrays.stream(pinsDownInALine.split(",")).map(string -> string.trim()).forEach((string) -> {
            pinsDownInALineList.add(string.equals("/") ? 0 : Integer.parseInt(string));
        });
        return pinsDownInALineList.stream().mapToInt(Integer::valueOf).toArray();
    }

    private boolean isInputStringLegal(String pinsDownInALine) {
        if (pinsDownInALine == null || pinsDownInALine.length() == 0)
            return false;
        for (char ch : pinsDownInALine.toCharArray()) {
            if (ch != '/' && ch != ',' && ch != ' ' && ch < '0' || ch > '9') return false;
        }
        return true;
    }

    boolean isTransferedIntArrayLegal(int[] pinsDownInALine) {
        boolean lengthCheck = isTheLengthOfTransferedIntArrayCorrect(pinsDownInALine);
        boolean numberRangeCheck = isTheNumberRangeOfTheTransferedIntArrayCorrect(pinsDownInALine);
        boolean pinsDownNumberBeforeFrameTenCheck = isThePinsDownNumberCorrectBeforeFrameTenCheck(pinsDownInALine);
        boolean pinsDownNumberInFrameTenCheck = isThePinsDownNumberCorrectInFrameTenCheck(pinsDownInALine);
        return lengthCheck && numberRangeCheck && pinsDownNumberBeforeFrameTenCheck && pinsDownNumberInFrameTenCheck;
    }

    private boolean isTheLengthOfTransferedIntArrayCorrect(int[] pinsDownInALine) {
        if (pinsDownInALine.length == totalThrowNumber) return true;
        return false;
    }

    private boolean isTheNumberRangeOfTheTransferedIntArrayCorrect(int[] pinsDownInALine) {
        for (int number : pinsDownInALine) {
            if (number > maxPinsDownNumberInAThrow || number < minPinsDownNumberInAThrow) return false;
        }
        return true;
    }

    private boolean isThePinsDownNumberCorrectBeforeFrameTenCheck(int[] pinsDownInALine) {
        for (int frame = 1; frame < totalFrameNumber; frame++) {
            if (pinsDownInALine[frame * 2 - 2] + pinsDownInALine[frame * 2 - 1] > maxPinsDownNumberInAFrameBeforeFrameTen)
                return false;
        }
        return true;
    }


    private boolean isThePinsDownNumberCorrectInFrameTenCheck(int[] pinsDownInALine) {
        int firstThrowIndexInFrameTen = totalFrameNumber * 2 - 2;
        int secondThrowIndexInFrameTen = firstThrowIndexInFrameTen + 1;
        int thirdThrowIndexInFrameTen = secondThrowIndexInFrameTen + 1;
        if (pinsDownInALine[firstThrowIndexInFrameTen] < 10 && pinsDownInALine[firstThrowIndexInFrameTen] + pinsDownInALine[secondThrowIndexInFrameTen] > 10)
            return false;
        if (pinsDownInALine[firstThrowIndexInFrameTen] + pinsDownInALine[secondThrowIndexInFrameTen] < 10 && pinsDownInALine[thirdThrowIndexInFrameTen] > 0)
            return false;
        return true;
    }

    int calculateTotalScore(String pinsDownInALine) throws Exception {
        int[] pinsDownInALineArray = inputTransfer(pinsDownInALine);
        if (!isTransferedIntArrayLegal(pinsDownInALineArray))
            throw new Exception("There is something error with the pins number record!");
        int totalScore = 0;
        int throwIndex = 0;
        int firstThrowIndexInFrameTen = totalFrameNumber * 2 - 2;
        int secondThrowIndexInFrameTen = firstThrowIndexInFrameTen + 1;
        int thirdThrowIndexInFrameTen = secondThrowIndexInFrameTen + 1;
        while (throwIndex < firstThrowIndexInFrameTen) {
            totalScore += pinsDownInALineArray[throwIndex] + pinsDownInALineArray[throwIndex + 1];
            if (pinsDownInALineArray[throwIndex] == maxPinsDownNumberInAThrow) {
                totalScore += calculateScoreWhenSpike(pinsDownInALineArray, throwIndex);
            } else if (pinsDownInALineArray[throwIndex] + pinsDownInALineArray[throwIndex + 1] == 10) {
                totalScore += pinsDownInALineArray[throwIndex + 2];
            }
            throwIndex += 2;
        }
        totalScore += pinsDownInALineArray[firstThrowIndexInFrameTen] + pinsDownInALineArray[secondThrowIndexInFrameTen] + pinsDownInALineArray[thirdThrowIndexInFrameTen];
        return totalScore;
    }

    private int calculateScoreWhenSpike(int[] pinsDownInALineArray, int throwIndex) {
        int frameScore = pinsDownInALineArray[throwIndex + 2];
        if (throwIndex != (totalFrameNumber - 1) * 2)
            frameScore += pinsDownInALineArray[throwIndex + 2] == 10 ? pinsDownInALineArray[throwIndex + 2 * 2] :
                    pinsDownInALineArray[throwIndex + 2 + 1];
        else frameScore += pinsDownInALineArray[throwIndex + 2 + 1];
        return frameScore;
    }
}
