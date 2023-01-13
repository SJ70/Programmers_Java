class Solution {
    static StringBuilder sb = new StringBuilder();
    static int distance;
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        x--;
        y--;
        r--;
        c--;

        distance = getDistance(r,c,x,y);
        if(distance%2!=k%2 || distance>k) return "impossible";

        while(true){
            
            if(distance == k){
                while(x<r){
                    x++;
                    sb.append('d');
                }
                while(c<y){
                    y--;
                    sb.append('l');
                }
                while(y<c){
                    y++;
                    sb.append('r');
                }
                while(r<x){
                    x--;
                    sb.append('u');
                }
                return sb.toString();
            }

            else if(getDistance(r,c,x+1,y)<=k-1 && x+1<n){
                x++;
                k--;
                sb.append('d');
            }
            else if(getDistance(r,c,x,y-1)<=k-1 && y-1>=0){
                y--;
                k--;
                sb.append('l');
            }
            else if(getDistance(r,c,x,y+1)<=k-1 && y+1<m){
                y++;
                k--;
                sb.append('r');
            }
            else if(getDistance(r,c,x-1,y)<=k-1 && x-1>=0){
                x--;
                k--;
                sb.append('u');
            }

            distance = getDistance(r,c,x,y);
        }
    }
    public static int getDistance(int r, int c, int x, int y){
        return Math.abs(r-x)+Math.abs(c-y);
    }
}
