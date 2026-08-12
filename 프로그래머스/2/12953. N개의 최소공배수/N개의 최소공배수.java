class Solution {
    public int gcd(int num1, int num2){
        for (int i = Math.min(num1, num2); i >= 2; i--){
            if (num1 % i == 0 && num2 % i == 0){
                return i;
            }
        }
        return 1;
    }
    
    public int lcm(int num1, int num2){
        return num1 * num2 / gcd(num1, num2);
    }
    
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
            // System.out.println("answer : " + answer);
        }
        
        return answer;
    }
}