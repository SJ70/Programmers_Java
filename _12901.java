class Solution {
    public String solution(int a, int b) {
        int[] daysPerMonth = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        
        int dayValue = b;
        for(int i=1; i<a; i++){
            dayValue += daysPerMonth[i];
        }
        
        String[] DayOfTheWeek = new String[]{"THU","FRI","SAT","SUN","MON","TUE","WED"};
        return DayOfTheWeek[dayValue%7];
    }
}
