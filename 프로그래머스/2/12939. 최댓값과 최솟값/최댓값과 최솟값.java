import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strArray = s.split(" ");
        List<Integer> numList = new ArrayList<>();
        Integer max_val = Integer.MIN_VALUE;
        Integer min_val = Integer.MAX_VALUE;
        
        for (String str : strArray){
            max_val = Math.max(Integer.parseInt(str), max_val);
            min_val = Math.min(Integer.parseInt(str), min_val);
            
            numList.add(Integer.parseInt(str));
        }
        
        
        
        return min_val + " " + max_val;
    }
}