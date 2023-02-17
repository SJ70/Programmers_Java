class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dist = (long)d*(long)d;
        for(long x=0; x*x<=dist; x+=(long)k){
            long y = (long)Math.sqrt(dist - x*x);
            answer += y/k+1;
        }
        return answer;
    }
}
