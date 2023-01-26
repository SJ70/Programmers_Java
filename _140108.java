class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char c = '.';
        int i = 0;
        int length = 0;
        
        while(true){
            if(length == 0){
                c = s.charAt(i);
                length++;
            }
            else{
                if(s.charAt(i)!=c){
                    length--;
                    if(length == 0){
                        answer++;
                    }
                }
                else{
                    length++;
                }
            }
            i++;
            if(i==s.length()) break;
        }
        if(length>0) answer++;
        
        return answer;
    }
}
