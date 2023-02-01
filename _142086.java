class Solution {
    public int[] solution(String s) {
        Integer[] alphabets = new Integer[26];
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i)-'a';
            answer[i] = (alphabets[index]==null) ? -1 : i - alphabets[index];
            alphabets[index] = i;
        }
        return answer;
    }
}
