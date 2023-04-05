import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i=0; i<balls.length; i++){
            answer[i] = getMinDist(m, n, startX, startY, balls[i][0], balls[i][1]);
        }
        return answer;
    }
    public int getMinDist(int m, int n, int r1, int c1, int r2, int c2){
        Queue<Integer> dist = new ArrayDeque<>();
        if(c1!=c2 || r1<r2) dist.add(getDist(r1, c1, -r2, c2));
        if(r1!=r2 || c1<c2) dist.add(getDist(r1, c1, r2, -c2));
        if(c1!=c2 || r1>r2) dist.add(getDist(r1, c1, m+m-r2, c2));
        if(r1!=r2 || c1>c2) dist.add(getDist(r1, c1, r2, n+n-c2));
        
        // System.out.println(dist.peek());
        int minDist = dist.poll();
        while(!dist.isEmpty()){
            // System.out.println(dist.peek());
            minDist = Math.min(minDist, dist.poll());
        }
        return minDist;
    }
    public int getDist(int r1, int c1, int r2, int c2){
        return (r1-r2)*(r1-r2) + (c1-c2)*(c1-c2);
    }
}
