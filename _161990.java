class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        for(int r=0; r<wallpaper.length; r++){
            for(int c=0; c<wallpaper[0].length(); c++){
                if(wallpaper[r].charAt(c)=='#'){
                    answer[0] = Math.min(answer[0], r);
                    answer[1] = Math.min(answer[1], c);
                    answer[2] = Math.max(answer[2], r+1);
                    answer[3] = Math.max(answer[3], c+1);
                }
            }
        }
        
        return answer;
    }
}
