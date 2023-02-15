import java.util.*;

class Solution {
    public class Node{
        ArrayList<Integer> Route = new ArrayList<>();
        int nextIndex = 0;
        Queue<Integer> Balls = new ArrayDeque<>();
        int score = 0;
        
        public void addRoute(int n){
            Route.add(n);
        }
        public void sortRoute(){
            Collections.sort(Route);
        }
        public void addBall(int i){
            Balls.add(i);
        }
        public void pass(){
            nextIndex++;
            if(nextIndex==Route.size()) nextIndex=0;
        }
        public int getNext(){
            return Route.get(nextIndex);
        }
        public boolean hasRoute(){
            return Route.size()>0;
        }
    }
    
    Node[] Nodes;
    int ScoreLeftNodeCnt = 0;
    public int[] solution(int[][] edges, int[] target) {
        
        int N = target.length;
        
        // 트리 초기화
        Nodes = new Node[N];
        for(int i=0; i<N; i++){
            Nodes[i] = new Node();
        }
        // 트리 입력
        for(int[] e : edges){
            Nodes[e[0]-1].addRoute(e[1]-1);
        }
        for(int i=0; i<N; i++){
            Nodes[i].sortRoute();
        }
        // 점수가 필요한 노드 수
        for(int e : target){
            if(e>0){
                ScoreLeftNodeCnt++;
            }
        }
                
        // 공 넣기
        int ballCnt=0;
        while(ScoreLeftNodeCnt>0){
            // 공이 도착할 인덱스 탐색
            int index = 0;
            while(Nodes[index].hasRoute()){
                int nextIndex = Nodes[index].getNext();
                Nodes[index].pass();
                index = nextIndex;
            }
            // 목표 점수가 0인데 공이 들어갈 경우
            if(target[index]==0) return new int[]{-1};
            // 넣었을 때 목표 점수보다 최솟값이 높아질 경우
            else if(target[index] < Nodes[index].Balls.size()+1) return new int[]{-1};
            // 넣었을 때 목표 점수를 만들 수 있도록 된 경우
            else if( target[index] > Nodes[index].Balls.size()*3 && target[index] <= (Nodes[index].Balls.size()+1)*3 ){
                ScoreLeftNodeCnt--;
            }
            Nodes[index].addBall(ballCnt);
            ballCnt++;
        }
        
        // // 각 노드에 들어간 공 인덱스
        // for(int i=0; i<N; i++){
        //     System.out.print((i+1)+": ");
        //     for(int ball : Nodes[i].Balls){
        //         System.out.print((ball+1)+",");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        
        // 공 값 구하기
        int[] result = new int[ballCnt];
        
        for(int i=0; i<N; i++){
            Queue<Integer> Balls = Nodes[i].Balls;
            
            int targetValue = target[i];
            
            for(int ballIndex : Balls){
                int value = 1;
                // 사전 순으로 가장 빠른 경우를 구하기 위한 연산
                if(targetValue == Balls.size()*3) value = 3;
                else if(targetValue == ((Balls.size()-1)*3) +2) value = 2;
                else if(targetValue == ((Balls.size()-1)*3) +1) value = 1;
                
                result[Balls.poll()] = value;
                targetValue -= value;
            }
        }
        
        // for(int i=0; i<ballCnt; i++){
        //     System.out.println(result[i]);
        // }
        
        return result;
    }
}
