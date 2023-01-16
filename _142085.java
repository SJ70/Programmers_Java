import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int round = 0;
        int soldier = n;
        int pass = k;
        while(round<enemy.length){
            // System.out.printf("병사 %d, 라운드 %d, 무적권 %d \n",soldier,round,pq.peek());
            soldier -= enemy[round];
            pq.add(enemy[round]);
            
            while(soldier<0 && pass>0){
                soldier += pq.poll();
                pass--;
            }
            if(soldier<0) break;
            round++;
        }
        
        return round;
    }
}
