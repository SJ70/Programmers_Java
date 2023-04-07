import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> index = new HashMap<>();
        for(int i=0; i<players.length; i++){
            index.put(players[i], i);
        }
        
        for(String name : callings){
            int i = index.get(name);
            
            players[i] = players[i-1];
            index.put(players[i-1], i);
            
            players[i-1] = name;
            index.put(name, i-1);
        }
        
        return players;
    }
}
