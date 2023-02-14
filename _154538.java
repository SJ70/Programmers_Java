import java.util.*;

class Solution {
    static final int INF = 2100000000;
    public int solution(int x, int y, int n) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        hs.put(x,0);
        
        for(int i=x+1; i<=y; i++){
            int value = hs.getOrDefault(i-n, INF);
            if(i%2==0) value = Math.min(value, hs.getOrDefault(i/2, INF));
            if(i%3==0) value = Math.min(value, hs.getOrDefault(i/3, INF));
            if(value!=INF) hs.put(i,value+1);
        }
        
        return hs.getOrDefault(y, -1);
    }
}
