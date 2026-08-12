import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> st = new HashSet<>();
        
        for (int start = 0; start < elements.length; start++){
            int answer = 0;
            for (int len = 1; len <= elements.length; len++){
                answer += elements[(start + len - 1) % elements.length];
                st.add(answer);
            }
        }
        
        return st.size();
    }
}