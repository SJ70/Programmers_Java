class Solution {
    public long solution(long n) {
        double root = Math.sqrt(n);
        if(root%1==0) return (long)Math.pow(root+1,2);
        else return -1;
    }
}
