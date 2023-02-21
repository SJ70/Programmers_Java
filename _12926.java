class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            int tmp = s.charAt(i);
            if(tmp!=' '){
                if(tmp>='A' && tmp<='Z' && tmp+n>'Z'){
                    tmp += n - 'Z' + 'A' -1;
                }
                else if(tmp>='a' && tmp<='z' && tmp+n>'z'){
                    tmp += n - 'z' + 'a' -1;
                }
                else tmp += n;
            }
            sb.append((char)tmp);
        }
        return sb.toString();
    }
}
