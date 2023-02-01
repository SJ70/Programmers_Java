class Solution {
    boolean solution(String s) {
        int tmp = 0;
        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case'P':
                case'p': tmp++; break;
                case'Y':
                case'y': tmp--; break;
            }
        }
        return tmp==0;
    }
}
