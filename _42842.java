import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        for (int r = 1; r <= yellow; r++) {
            if (yellow % r != 0) {
                continue;
            }
            int c = yellow / r;
            if (brown == r*2 + c*2 + 4) {
                return new int[] {c + 2, r + 2};
            }
        }
        return null;
    }
}
