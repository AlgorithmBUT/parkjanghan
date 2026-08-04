class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int count_zero = 0;
        int round_count = 0;
        String ans_str = s;
        
        while (true){
            
            char[] char_array = ans_str.toCharArray();
            ans_str = "";
            for (char ch : char_array) {
                if (ch == '1') ans_str += "1";
                else count_zero++;
            }        
            // System.out.println(ans_str);
        
            int str_leng = ans_str.length();
        
            ans_str = "";
            while (str_leng > 0){
                if (str_leng % 2 == 1) {
                    ans_str = "1" + ans_str;
                } else {
                    ans_str = "0" + ans_str;
                }
                str_leng /= 2;
            }
            System.out.println(ans_str);
            round_count++;
            if (ans_str.equals("1")) break;
        }
        answer = new int[2];
        answer[0] = round_count;
        answer[1] = count_zero;
        return answer;
    }
}