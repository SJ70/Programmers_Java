class Solution {
    public String solution(String X, String Y) {
        int[] xNums = new int[10];
        for(int i=0; i<X.length(); i++)
            xNums[X.charAt(i)-'0']++;
        
        int[] yNums = new int[10];
        for(int i=0; i<Y.length(); i++)
            yNums[Y.charAt(i)-'0']++;
        
        int[] nums = new int[10];
        for(int i=0; i<10; i++)
            nums[i] = Math.min(xNums[i],yNums[i]);
        
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--)
            for(int j=0; j<nums[i]; j++)
                sb.append(i);
        
        String answer = sb.toString();
        if(answer.length()==0) return "-1";
        if(answer.charAt(0)=='0') return "0";
        return answer;
    }
}
