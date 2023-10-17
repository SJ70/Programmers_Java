import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        List<Integer> arr = new ArrayList<>(); 
        for (int i=0; i<n; i++) {
            arr.add(arr1[i] | arr2[i]);
        }
        
        return arr.stream()
            .map(value -> Integer.toString(value, 2))
            .map(string -> string.replace('1','#'))
            .map(string -> string.replace('0',' '))
            .map(string -> String.format("%" + n + "s", string))
            .toArray(String[]::new);
    }
}
