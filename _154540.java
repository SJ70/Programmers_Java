import java.util.*;
import java.io.*;

class Solution {
    static String[] Map;
    static int R,C;
    static boolean[][] visited;
    static int[] answer = new int[5000];
    
    
    public int[] solution(String[] maps) {
        Map = maps;
        R = maps.length;
        C = maps[0].length();
        visited = new boolean[R][C];
        
        int sectionNum = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(!visited[r][c] && Map[r].charAt(c)!='X'){
                    visit(r,c,sectionNum);
                    sectionNum++;
                }
            }
        }
        
        answer = Arrays.copyOf(answer, sectionNum);
        if(answer.length==0) answer = new int[] {-1};
        else Arrays.sort(answer);
        return answer;
    }
    public static void visit(int r, int c, int sectionNum){
        if(visited[r][c]) return;
        visited[r][c] = true;
        if(Map[r].charAt(c)=='X') return;
        answer[sectionNum] += (Map[r].charAt(c))-'0';
        if(r-1>=0) visit(r-1,c,sectionNum);
        if(r+1<R) visit(r+1,c,sectionNum);
        if(c-1>=0) visit(r,c-1,sectionNum);
        if(c+1<C) visit(r,c+1,sectionNum);
    }
}
