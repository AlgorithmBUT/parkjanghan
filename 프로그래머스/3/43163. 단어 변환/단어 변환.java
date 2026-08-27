import java.util.*;

class Solution {
    
    public class Word {
        String str;
        int depth;
        
        public Word (String str, int depth){
            this.str = str;
            this.depth = depth;
        }
    }
    
    public boolean strCmp(String a, String b){
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        
        int cnt = 0;
        for (int i = 0; i < a.length(); i++){
            if (aCharArray[i] != bCharArray[i]) cnt++; 
        }
        
        return cnt == 1 ? true : false; 
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        //BFS 
        boolean[] visited = new boolean[words.length];
        
        Deque<Word> q = new ArrayDeque<>();
        q.push(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word cur = q.pop();
            
            for (int i = 0; i < words.length; i++){
                if (visited[i]) continue;
                
                if (strCmp(words[i], cur.str)) {
                    if (words[i].compareTo(target) == 0) {
                        answer = cur.depth + 1;
                    }
                    visited[i] = true;
                    q.push(new Word(words[i], cur.depth + 1));
                }
            }
        }

        return answer;
    }
}