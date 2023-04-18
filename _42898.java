class Solution {
    static int[][] Map;
    public int solution(int m, int n, int[][] puddles) {
        Map = new int[m][n];
        for(int[] p : puddles){
            Map[p[0]-1][p[1]-1] = -1;
        }
        Map[0][0] = 1;
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(Map[r][c]==-1) continue;
                int fromTop = (r-1>=0 && Map[r-1][c]!=-1) ? Map[r-1][c] : 0;
                int fromLeft = (c-1>=0 && Map[r][c-1]!=-1) ? Map[r][c-1] : 0;
                Map[r][c] += (fromTop + fromLeft) % 1000000007;
            }
        }
        // for(int r=0; r<m; r++){
        //     for(int c=0; c<n; c++){
        //         System.out.printf("%3d",Map[r][c]);
        //     }
        //     System.out.println();
        // }
        
        return Map[m-1][n-1];
    }
}
