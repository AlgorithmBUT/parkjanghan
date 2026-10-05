import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dIdx = n-1, pIdx = n-1;
        int dCnt = 0, pCnt = 0;
        
        // **==** 이거 안 해서 1시간 개고생함 **==** ^^
        while (dIdx >= 0 && deliveries[dIdx] == 0){
                dIdx--;
        }
        
        while (pIdx >= 0 && pickups[pIdx] == 0){
                pIdx--;
        }
        
        while(dIdx >= 0 || pIdx >= 0){
            dCnt = cap; pCnt = cap;
            int maxIdx = Math.max(dIdx, pIdx) + 1;       // 가장 먼 거리
            // System.out.println(maxIdx);
            
            // dIdx 를 줄이면서 dCnt 늘리기
            while (dIdx >= 0 && dCnt > 0){
                if (dCnt >= deliveries[dIdx]){
                    dCnt -= deliveries[dIdx];
                    deliveries[dIdx] = 0;
                    dIdx--;
                } else {
                    deliveries[dIdx] -= dCnt;
                    dCnt = 0;
                }
            }
            
            while (dIdx >= 0 && deliveries[dIdx] == 0){
                dIdx--;
            }
            
            // System.out.println("deliveries : " + Arrays.toString(deliveries) + " " + dIdx);
            
            // dIdx 를 줄이면서 dCnt 늘리기
            while (pIdx >= 0 && pCnt > 0){
                if (pCnt >= pickups[pIdx]){
                    pCnt -= pickups[pIdx];
                    pickups[pIdx] = 0;
                    pIdx--;
                } else {
                    pickups[pIdx] -= pCnt;
                    pCnt = 0;
                }
            }
            
            while (pIdx >= 0 && pickups[pIdx] == 0){
                pIdx--;
            }
            
            // System.out.println("pickups : " + Arrays.toString(pickups) + " " + pIdx);
            
            answer += 2*maxIdx;
            
        }
        
        return answer;
    }
}