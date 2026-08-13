class Solution {
    public int solution(int n) {
        int answer = n+1;
        int cnt = Integer.bitCount(n);
        
        while (Integer.bitCount(answer) != cnt){
            answer++;
        }
        
        return answer;
    }
}