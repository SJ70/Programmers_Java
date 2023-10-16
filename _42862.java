import java.util.*;
import java.util.stream.*;

class Solution {
    
    private int n;
    private int[] arr;
    
    public int solution(int n, int[] lost, int[] reserve) {
        
        init(n, lost, reserve);
        // printStatus();
        
        borrow();
        // printStatus();
        
        return countLost();
    }
    
    private void init(int n, int[] lost, int[] reserve) {
        
        this.n = n;
        arr = new int[n];
        
        for (int lostIndex : lost) {
            arr[lostIndex - 1]--;
        }
        
        for (int reserveIndex : reserve) {
            arr[reserveIndex - 1]++;
        }
    }
    
    private void borrow() {
        for (int lostIndex = 0; lostIndex < n; lostIndex++) {
            
            // 이미 체육복을 가지고 있음
            if (arr[lostIndex] >= 0) {
                continue;
            }
            
            // 왼쪽에서 빌려옴
            int left = lostIndex - 1;
            if (left >= 0 && arr[left] == 1) {
                arr[lostIndex] = 0;
                arr[left] = 0;
                continue;
            }
            
            // 오른쪽에서 빌려옴
            int right = lostIndex + 1;
            if (right < n && arr[right] == 1) {
                arr[lostIndex] = 0;
                arr[right] = 0;
                continue;
            }
        }
    }
    
    private int countLost() {
        return Arrays.stream(arr)
            .map(value -> value >= 0 ? 1 : 0)
            .reduce(0, (a, b) -> a + b);
    }
    
}