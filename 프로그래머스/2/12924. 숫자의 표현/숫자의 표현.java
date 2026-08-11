class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int i;
        for (i = 0; i < n; i++){
            int sum = 0;
            for (int j = i+1; j <= n; j++){            
                sum += j;
                if (sum > n) break;
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}