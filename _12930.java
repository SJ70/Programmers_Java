import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()){
            // 단어가 나올 때까지 탐색
            for(; i<s.length(); i++){
                if(s.charAt(i)==' ') sb.append(' ');
                else break;
            }
            // 단어 입력
            int wordIndex=0;
            for(; i<s.length(); i++){
                char c = s.charAt(i);
                if(c==' ') break;
                else if(wordIndex%2==0){
                    if(c>='a' && c<='z') c = (char)(c+'A'-'a');
                }
                else {
                    if(c>='A' && c<='Z') c = (char)(c-'A'+'a');
                }
                sb.append(c);
                wordIndex++;
            }
        }
        return sb.toString();
    }
}
