class Solution {
    public int solution(int[] nums) {
        initIsNotDecimal();
        
        int answer = 0;
        
        for(int a=0; a<nums.length-2; a++){
            for(int b=a+1; b<nums.length-1; b++){
                for(int c=b+1; c<nums.length; c++){
                    if(isDecimal(nums[a]+nums[b]+nums[c])) answer++;
                }
            }
        }
        
        return answer;
    }
    boolean[] isNotDecimal = new boolean[3001];
    public void initIsNotDecimal(){
        isNotDecimal[0] = isNotDecimal[1] = true;
        for(int i=2; i<=3000; i++){
            if(!isNotDecimal[i]){
                for(int k=i*2; k<=3000; k+=i){
                    isNotDecimal[k] = true;
                }
            }
        }
    }
    public boolean isDecimal(int i){
        return !isNotDecimal[i];
    }
}
