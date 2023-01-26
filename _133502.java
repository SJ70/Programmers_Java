import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> S = new Stack<>();
        int answer = 0;
        
        for(int element : ingredient){
            if(element==1 && S.size()>=3){
                if(S.peek()==3){
                    S.pop();
                    if(S.peek()==2){
                        S.pop();
                        if(S.peek()==1){
                            S.pop();
                            answer++;
                            continue;
                        }
                        S.push(2);
                    }
                    S.push(3);
                }
            }
            S.add(element);
        }
        return answer;
    }
}
