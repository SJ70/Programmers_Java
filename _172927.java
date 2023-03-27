import java.util.*; 

class Solution {
    static PriorityQueue<Integer> M = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int[] picks, String[] minerals) {
        initMinerals(minerals, picks[0]+picks[1]+picks[2]);
        
        int result = 0;
        for(int i=0; i<3; i++){
            for(; picks[i]>0; picks[i]--){
                result += getTired(i, M.poll());
                if(M.isEmpty()) break;
            }
            if(M.isEmpty()) break;
        }
        return result;
    }
    public void initMinerals(String[] m, int pickCnt){
        // 100:diamond, 10:iron, 1:stone
        int value = 0;
        for(int i=0; i<m.length; i++){
            if(i>0 && i%5==0){
                M.add(value);
                value = 0;
                // 곡괭이의 수가 모든 광물을 캐기에 모자랄 때
                if(M.size()==pickCnt) return;
            } 
            switch(m[i]){
                case "diamond" : value+=100; break;
                case "iron" : value+=10; break;
                case "stone" : value+=1; break;
                default : break;
            }
        }
        M.add(value);
    }
    public int getTired(int pick, int value){
        int diamond = value/100;
        int iron = value%100/10;
        int stone = value%10;
        // System.out.println(diamond+","+iron+","+stone);
        switch(pick){
            case 0 : return diamond + iron + stone;
            case 1 : return diamond*5 + iron + stone;
            case 2 : return diamond*25 + iron*5 + stone;
            default : return -1;
        }
    }
}
