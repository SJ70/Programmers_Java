class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<myString.length(); i++){
            char c = myString.charAt(i);
            if(c<='Z') c += 'a'-'A';
            sb.append(c);
        }
        return sb.toString();
    }
}
