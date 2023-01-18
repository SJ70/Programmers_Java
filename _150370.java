import java.util.*;

class Solution {
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        Today = DateValueOf(today);
        setTerms(terms);
        checkPrivacies(privacies);
        return ArrayOf(Answer);
    }
    
    static int Today;
    static HashMap<Character, Integer> Terms = new HashMap<>();
    static List<Integer> Answer = new ArrayList<>();
    
    public static int DateValueOf(String day){
        StringTokenizer st = new StringTokenizer(day,".");
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        return ((y*12)+m)*28+d;
    }
    public static void setTerms(String[] terms){
        for(int i=0; i<terms.length; i++){
            StringTokenizer st = new StringTokenizer(terms[i]);
            char code = st.nextToken().charAt(0);
            int year = Integer.parseInt(st.nextToken());
            Terms.put(code,year);
        }
    }
    public static void checkPrivacies(String[] days){
        for(int i=0; i<days.length; i++){
            StringTokenizer st = new StringTokenizer(days[i]);
            int date = DateValueOf(st.nextToken());
            int termYear = Terms.get(st.nextToken().charAt(0));
            
            int limit = date + (termYear * 28) - 1;
            if(limit < Today) Answer.add(i+1);
        }
    }
    public static int[] ArrayOf(List<Integer> li){    
        int[] answer = new int[li.size()];
        for(int i=0; i<li.size(); i++){
            answer[i] = li.get(i);
        }
        return answer;
    }
}
