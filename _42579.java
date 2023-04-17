import java.util.*;

class Solution {
    public class Genre implements Comparable<Genre>{
        int plays = 0;
        ArrayList<Music> M = new ArrayList<>();
        
        public int compareTo(Genre g){
            return g.plays - this.plays;
        }
        public void addMusic(Music m){
            M.add(m);
            this.plays+=m.plays;
        }
    }
    public class Music implements Comparable<Music>{
        int num, plays;
        public Music(int n, int p){
            num = n;
            plays = p;
        }
        
        public int compareTo(Music m){
            return m.plays - this.plays;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        
        int N = genres.length;
        int gCnt = 0;
        HashMap<String, Integer> genreIndex = new HashMap<>();
        ArrayList<Genre> G = new ArrayList<>();
        for(String g : genres){
            if(!genreIndex.containsKey(g)){
                genreIndex.put(g, gCnt++);
                G.add(new Genre());
            }
        }
        
        for(int i=0; i<N; i++){
            int index = genreIndex.get(genres[i]);
            Music M = new Music(i, plays[i]);
            G.get(index).addMusic(M);
        }
        
        Collections.sort(G);
        for(int i=0; i<gCnt; i++){
            // System.out.println(G.get(i).plays);
            Collections.sort(G.get(i).M);
            // for(Music m : G.get(i).M){
            //     System.out.println("  "+m.plays);
            // }
        }
                
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<gCnt; i++){
            result.add(G.get(i).M.get(0).num);
            if(G.get(i).M.size()>=2) result.add(G.get(i).M.get(1).num);
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
