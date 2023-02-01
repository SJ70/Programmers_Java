class Solution {
    public int[] solution(long n) {
        int[] answer = new int[(int)Math.log10(n)+1];
        for(int i=0; i<answer.length; i++){
            answer[i] = (int)(n%10L);
            n/=10L;
        }
        return answer;
    }
}
