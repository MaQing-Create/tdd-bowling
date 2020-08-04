import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingGame {

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
            if (ch != '/' && ch < '0' || ch > '9') return false;
        }
        return true;
    }
}
