import java.util.*;

class Solution
{
    public int solution(String s){
        
//         StringBuilder sb = new StringBuilder(s);
//         // System.out.println(sb);
//         boolean solable;
//         char next_ch;
//         char ch;
        
//         while(sb.length() != 0){
//             solable = false;
//             ch = sb.charAt(0);
//             for (int i = 0; i < sb.length() -1; i++){
//                 next_ch = sb.charAt(i+1);
//                 if (ch == next_ch){
//                     sb.delete(i,i+2);
//                     solable = true;
//                     break;
//                 }
//                 ch = next_ch;
//             }
//             if (!solable) return 0;
//         }
        
//         return 1;
        
        Deque<Character> stk = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length(); i++){
            char ch = sb.charAt(i);
            if (stk.isEmpty()) {
                stk.push(ch);
            } else if (!stk.isEmpty() && stk.peek() == ch) {
                stk.pop();
            } else {
                stk.push(ch);
            }
        }
        
        return stk.isEmpty()? 1 : 0 ;
    }
}