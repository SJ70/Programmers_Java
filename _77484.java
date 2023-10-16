import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int zeroCount = (int)Arrays.stream(lottos)
            .filter(value -> value == 0)
            .count();
        
        int sameCount = Arrays.stream(lottos)
                .reduce(0, (result, value) -> {
                    boolean found = Arrays.stream(win_nums)
                            .anyMatch(currentValue -> currentValue == value);
                    return result + (found ? 1 : 0);
                });
        
        int maxSameCount = sameCount + zeroCount;
        int minSameCount = sameCount;
        
        int maxScore = 7 - maxSameCount;
        if (maxScore == 7) {
            maxScore = 6;
        }
        
        int minScore = 7 - minSameCount;
        if (minScore == 7) {
            minScore = 6;
        }
        
        int[] answer = new int[] {maxScore, minScore};
        return answer;
    }
}
