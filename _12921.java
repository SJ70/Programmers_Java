class Solution {
    public int solution(int n) {
        boolean[] isNotDecimal = new boolean[n+1];
        int answer = 0;
        for(int i=2; i<=n; i++){
            if(!isNotDecimal[i]){
                answer++;
                for(int j=i*2; j<=n; j+=i){
                    isNotDecimal[j]=true;
                }
            }
        }
        return answer;
    }
}
