import java.util.*;

class Solution {
    static String[] name;
    static PriorityQueue<int[]> project = new PriorityQueue<>(
        new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        }
    );
    static Stack<int[]> hold = new Stack<>();
    static Queue<Integer> result = new ArrayDeque<>();
    
    public String[] solution(String[][] plans) {
        
        init(plans);
        // while(!project.isEmpty()){
        //     int[] a = project.poll();
        //     System.out.printf("%d %d %d\n",a[0], a[1], a[2]);
        // }
        
        int[] current;
        int time = 0;
        while(!project.isEmpty() || !hold.isEmpty()){

            // 남은 과제가 없을 경우 멈춘 과제를 모두 수행
            if(project.isEmpty()){
                while(!hold.isEmpty()){
                    result.add(hold.pop()[0]);
                }
                break;
            }

            // 다음 과제 시작 시간인 경우 새 과제 시작
            if(time==project.peek()[1]){
                current = project.poll();
            }
            // 멈춘 과제 수행
            else if(!hold.isEmpty()){
                current = hold.pop();
            }
            // 시간이 남아돌고 멈춘 과제가 없을 때 : 다음 과제 수행
            else{
                current = project.poll();
                time = current[1];
            }
            // System.out.printf("current : %d, time : %d, rest : %d \n",current[0],time,current[2]);
            
            // 현재 과제가 다음 과제 시작 시간에 끝날 경우 결과 큐에 집어넣음
            int end = time+current[2];
            int nextStart = project.isEmpty() ? 9999 : project.peek()[1];
            if(end <= nextStart){
                // System.out.printf("complete : %d \n",current[0]);
                result.add(current[0]);
                time = end;
            }
            else{ // 아닐 경우 남은 시간을 줄이고 잠시 멈춰둠
                current[2] -= nextStart - time;
                // System.out.printf("hold : %d, %d \n",current[0],current[2]);
                hold.push(current);
                time = project.peek()[1];
            }
            
        }
        
        
        String[] answer = new String[result.size()];
        for(int i=0; !result.isEmpty(); i++){
            answer[i] = name[result.poll()];
        }
        return answer;
    }
    
    public static void init(String[][] arr){
        name = new String[arr.length];
        for(int i=0; i<arr.length; i++){
            name[i] = arr[i][0];
            
            StringTokenizer st = new StringTokenizer(arr[i][1],":");
            int start = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            int playtime = Integer.parseInt(arr[i][2]);
            project.add( new int[]{ i, start, playtime } );
        }
    }
}
