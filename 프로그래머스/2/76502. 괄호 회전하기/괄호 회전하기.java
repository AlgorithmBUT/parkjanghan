import java.util.*;

class Solution {
    
    public boolean isValid(String s, int start) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt((start + i) % n);
            
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                
                if (ch == ')' && top != '(') return false;
                if (ch == ']' && top != '[') return false;
                if (ch == '}' && top != '{') return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        
        for (int start = 0; start < s.length(); start++) {
            if (isValid(s, start)) {
                answer++;
            }
        }
        
        return answer;
    }
}