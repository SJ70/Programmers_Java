class Solution {
    public int solution(int n) {
        int answer = 0;
        double root = Math.sqrt(n);
        for(int i=1; i<root; i++){
            if(n%i==0){
                answer += i + n/i;
            }
        }
        if(root%1==0 && n%root==0) answer+=root;
        return answer;
    }
}
