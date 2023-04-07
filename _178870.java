class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int sum = sequence[0];
        int[] answer = new int[2];
        
        while(true){
            // System.out.println(left+"~"+right+":"+sum);
            if(sum==k && (length > right-left)){
                answer[0]=left;
                answer[1]=right;
                length = right-left;
            }
            if(sum<k){
                right++;
                if(right==sequence.length) break;
                sum+=sequence[right];
            }
            else{
                sum-=sequence[left];
                left++;
            }
        }
        
        return answer;
    }
}
