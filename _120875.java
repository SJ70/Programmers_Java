class Solution {
    public int solution(int[][] dots) {
        if (
            isSameSlope(dots[0], dots[1], dots[2], dots[3]) ||
            isSameSlope(dots[0], dots[2], dots[1], dots[3]) ||
            isSameSlope(dots[0], dots[3], dots[1], dots[3]) 
        ){
            return 1;
        } 
        else {
            return 0;
        }
    }
    
    private boolean isSameSlope(int[] dot1, int[] dot2, int[] dot3, int[] dot4){
        int line1dx = (dot1[1] - dot2[1]);
        int line1dy = (dot1[0] - dot2[0]);
        int line2dx = (dot3[1] - dot4[1]);
        int line2dy = (dot3[0] - dot4[0]);
        return line1dy * line2dx == line1dx * line2dy;
    }
}
