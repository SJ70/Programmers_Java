class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int dIndex, pIndex;
        dIndex = pIndex = n - 1;
        
        while(dIndex >= 0 || pIndex >= 0){
            // 배달, 수거 시작 인덱스 탐색
            for(; (dIndex >= 0 && deliveries[dIndex]==0); dIndex--);
            for(; (pIndex >= 0 && pickups[pIndex]==0); pIndex--);
            // 결과값 추가
            answer += (long)(Math.max(dIndex, pIndex)+1) * 2;
            
            // 배달
            dIndex = doDeliveryOrPickup(cap, deliveries, dIndex);
            // 수거
            pIndex = doDeliveryOrPickup(cap, pickups, pIndex);
        }
        
        return answer;
    }
    private int doDeliveryOrPickup(int cap, int[] arr, int index){
        int Cap = cap;
        while(index >= 0 && Cap > 0){
            int sub = Math.min(Cap, arr[index]);
            Cap -= sub;
            arr[index] -= sub;
            if(arr[index]==0) index--;
        }
        return index;
    }
}
