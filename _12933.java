import java.util.*;
class Solution {
    public long solution(long n) {
        ArrayList<Long> arr = new ArrayList<>();
        for(; n>0; n/=10){
            arr.add(n%10);
        }
        Collections.sort(arr, Collections.reverseOrder());
        
        long answer = 0L;
        for(long e : arr){
            answer = answer*10+e;
        }
        return answer;
    }
}
