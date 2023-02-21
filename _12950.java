class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int R = arr1.length;
        int C = arr1[0].length;
        int[][] answer = new int[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                answer[r][c] = arr1[r][c] + arr2[r][c];
            }
        }
        return answer;
    }
}
