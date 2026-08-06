class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int big_size = brown + yellow;
        int small_size = yellow;
        
        for (int i = 1; i <= small_size; i++){
            if ((small_size % i) != 0) continue;
            
            int j = small_size / i;
            
            if (big_size == (i+2)*(j+2)) {
                answer[0] = i > j? i+2 : j+2;
                answer[1] = i > j? j+2 : i+2; 
            } 
        }
        
        return answer;
    }
}