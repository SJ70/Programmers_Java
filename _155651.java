import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        inputArrayList(book_time);
        Collections.sort(Arr);
        // System.out.println(Arr);
        for(int e : Arr){
            for(int i=0; i<1000; i++){
                if(times[i] <= getStartTime(e)){
                    times[i] = getEndTime(e) + 10;
                    break;
                }
            }
        }
        int cnt = 0;
        for(; cnt<1000 && times[cnt]>0; cnt++);
        return cnt;
    }
    static ArrayList<Integer> Arr = new ArrayList<>();
    static int[] times = new int[1000];
    public static void inputArrayList(String[][] arr){
        for(String[] e : arr){
            Arr.add(intValueOfTime(e[0]) * 10000 + intValueOfTime(e[1]));
        }
    }
    public static int intValueOfTime(String str){
        StringTokenizer st = new StringTokenizer(str,":");
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        return H*60 + M;
    }
    public static int getStartTime(int n){
        return n/10000;
    }
    public static int getEndTime(int n){
        return n%10000;
    }
}
