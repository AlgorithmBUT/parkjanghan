class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int before_2 = 0;
        int before_1 = 1;
        int temp = -1;
        
        for (int i = 2; i <= n; i++){
            temp = (before_2 + before_1) % 1234567;
            before_2 = before_1;
            before_1 = temp;
        }
        
        answer = temp;
        return answer;
    }
}