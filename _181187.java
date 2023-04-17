class Solution {
    public long solution(int r1, int r2) {
        
        long result = 0;
        for(int i=1; i<=r2; i++){
            int a = (int)Math.floor( Math.sqrt( Math.pow(r2,2) - Math.pow(i,2) ) );
            int b = (int)Math.ceil( Math.sqrt( Math.pow(r1,2) - Math.pow(i,2) ) );
            // System.out.printf("%d : %d~%d\n",i,a,b);
            result += a-b+1;
        }
        
        return result*4;
    }
}
