import java.util.*;

class Solution {
    static String[] Park;
    static int R,C;
    static int[] Pos;
    public int[] solution(String[] park, String[] routes) {
        init(park);
        
        for(String s : routes){
            StringTokenizer st = new StringTokenizer(s);
            int[] dir = getDir(st.nextToken().charAt(0));
            int dist = Integer.parseInt(st.nextToken());
            if(canGo(dir, dist)){
                Pos[0] += dir[0]*dist;
                Pos[1] += dir[1]*dist;
            }
        }
        
        return Pos;
    }
    public void init(String[] park){
        Park = park;
        R = park.length;
        C = park[0].length();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(park[r].charAt(c)=='S'){
                    Pos = new int[] {r,c};
                    return;
                }
            }
        }
    }
    public int[] getDir(char dir){
        switch(dir){
            case 'N' : return new int[] {-1,0};
            case 'S' : return new int[] {1,0};
            case 'W' : return new int[] {0,-1};
            case 'E' : return new int[] {0,1};
            default : return new int[] {0,0};
        }
    }
    public boolean canGo(int[] dir, int dist){
        int r = Pos[0]+dir[0]*dist;
        int c = Pos[1]+dir[1]*dist;
        if(r<0 || r>=R || c<0 || c>=C) return false;
        
        r = Pos[0];
        c = Pos[1];
        for(int i=0; i<dist; i++){
            r+=dir[0];
            c+=dir[1];
            if(Park[r].charAt(c)=='X') return false;
        }
        return true;
    }
}
