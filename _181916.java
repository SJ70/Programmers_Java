import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        PriorityQueue<Integer> nums = new PriorityQueue<>(Collections.reverseOrder());
        nums.add(a);
        nums.add(b);
        nums.add(c);
        nums.add(d);
        
        a = nums.poll();
        b = nums.poll();
        c = nums.poll();
        d = nums.poll();
        
        // 4개 일치
        if (a == d){
            return a*1111;
        } 
        
        // 3개 일치
        else if (a == c){
            return (int)Math.pow((10 * a + d), 2);
        }
        else if (b == d){
            return (int)Math.pow((10 * b + a), 2);
        }
        
        // 2개 일치
        else if (a == b){
            if (c == d){
                return (a + c) * (a - c);
            }
            else {
                return c * d;
            }
        }
        else if (b == c){
            return a * d;
        }
        else if (c == d){
            return a * b;
        }
        
        // 불일치
        else return d;
    }
}
