import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> mp = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++){
            int t = tangerine[i];
            mp.put(t, mp.getOrDefault(t, 0) + 1);
        }
        
        // for (Entry<Integer, Integer> entry : mp){
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // }
        
        List<Integer> list = new ArrayList<>(mp.keySet());
        
        list.sort((a, b) -> {
            return mp.get(b) - mp.get(a);
        });
        
        int answer = 0;
        for (Integer i : list) {
            k -= mp.get(i);
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}