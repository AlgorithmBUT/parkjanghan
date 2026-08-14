import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        Set<String> set = new HashSet<>();
        
        char last_ch= '1';
        
        int i = 0;
        for (i = 0; i < words.length; i++){
            String word = words[i];
            if (set.contains(word)) break;
            if (word.charAt(0) != last_ch && i != 0) break;
            
            set.add(word);
            last_ch = word.charAt(word.length()-1);
        }
        
        // System.out.println("i : " + i);
        
        if (i == words.length) return new int[]{0, 0};
        
        int round = i / n + 1;
        int per_num = i % n + 1;

        return new int[]{per_num, round};
    }
}