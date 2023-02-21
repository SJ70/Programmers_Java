import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.charAt(n)!=b.charAt(n)) return a.charAt(n)-b.charAt(n);
                else{
                    for(int i=0; i<a.length() && i<b.length(); i++){
                        if(a.charAt(i)!=b.charAt(i)){
                            return a.charAt(i)-b.charAt(i);
                        }
                        if(i==a.length()-1) return -1;
                        else if(i==b.length()-1) return 1;
                    }
                };
                return 0;
            }
        });
        return strings;
    }
}
