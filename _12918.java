class Solution {
    public boolean solution(String s) {
        try{
            Integer.parseInt(s);
        }
        catch(Exception e){
            return false;
        }
        return s.length()==4 || s.length()==6;
    }
}
