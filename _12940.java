class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        if(n>m){
            int tmp = n;
            n=m;
            m=tmp;
        }
        //공약수
        for(int i=n; i>=1; i--){
            if(m%i==0 && n%i==0){
                answer[0] = i;
                break;
            }
        }
        //공배수
        for(int i=m; true; i+=m){
            if(i%n==0){
                answer[1] = i;
                break;
            }
        }
        
        return answer;
    }
}
