class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1) return new int[]{-1};
        
        int min = arr[0];
        for(int e : arr){
            min = Math.min(min,e);
        }
        int[] answer = new int[arr.length-1];
        int i=0;
        for(int e : arr){
            if(e!=min){
                answer[i++]=e;
            }
        }
        return answer;
    }
}
