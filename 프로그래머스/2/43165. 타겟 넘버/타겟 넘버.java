class Solution {
    
    int numLength = 0;
    int answer = 0;
    
    public void calculate(boolean[] boolArray, int[] numbers, int target){
        int result = 0;
        
        for (int i = 0; i < numLength; i++){
            if (boolArray[i]) {
                result += numbers[i];
                // System.out.print("+");
            }
            else {
                result -= numbers[i];
                // System.out.print("-");
            }

            // System.out.print(numbers[i] + " ");
        }
        
        // System.out.println();
        
        if (result == target) answer++;
    }
    
    public void dfs(int[] numbers, boolean[] boolArray, int target, int depth){
        if (numLength == depth) {
            calculate(boolArray, numbers, target);
            return;
        }
        
        boolArray[depth] = true;
        dfs(numbers, boolArray, target, depth + 1);
        
        boolArray[depth] = false;
        dfs(numbers, boolArray, target, depth + 1);
        
        return;
    }
    
    public int solution(int[] numbers, int target) {
        
        numLength = numbers.length;
        boolean[] boolArray = new boolean[numLength];
        
        dfs(numbers, boolArray, target, 0);
        
        return answer;
    }
}