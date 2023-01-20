import java.util.*;
class Solution {
    
    public long solution(int[] weights) {
        inputMap(weights);
        for(int e : weights){
            addAnswer(e);
            hm.remove(e);
        }
        
        return answer;
    }
    
    static HashMap<Integer,Long> hm = new HashMap<>();
    static long answer = 0;
    
    public void inputMap(int[] arr){
        for(int e : arr){
            hm.put(e,hm.getOrDefault(e, 0L) + 1L);
        }
    }
    
    public void addAnswer(int n){
        if(hm.containsKey(n)){
            long cnt = hm.get(n);
            
            // 동일한 값
            if(cnt>1){
                for(long k=(long)(cnt-1); k>0; k--){
                    answer += k;
                }           
            }
            
            answer += cnt * hm.getOrDefault(n*2,0L);
            
            if(n%2==0){
                answer += cnt * hm.getOrDefault(n/2,0L);
                answer += cnt * hm.getOrDefault(n/2*3,0L);
            } 
            if(n%3==0){
                answer += cnt * hm.getOrDefault(n/3*2,0L);
                answer += cnt * hm.getOrDefault(n/3*4,0L);
            }
            if(n%4==0){
                answer += cnt * hm.getOrDefault(n/4*3,0L);
            } 
        }
    }
}
