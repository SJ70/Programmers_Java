class Solution {
    public int solution(int num) {
        long N = num;
        int repeat = 0;
        while(N>1){
            if(N%2==0) N/=2;
            else N = N*3+1;
            repeat++;
            if(repeat>500) return -1;
        }
        return repeat;
    }
}
