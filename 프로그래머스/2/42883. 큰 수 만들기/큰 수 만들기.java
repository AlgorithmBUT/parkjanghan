
import java.util.*;

class Solution {

    static Deque<Integer> ans = new ArrayDeque<>();

    public String solution(String number, int k) {

        StringBuilder res = new StringBuilder();

        for (char n : number.toCharArray()){

            int num = n - '0';

            while (!ans.isEmpty() && k>0 && ans.peekLast()<num){
                ans.pollLast();
                k--;
            }

            ans.offerLast(num);
        }

        while (k >0){
            ans.pollLast();
            k--;
        }

        while (!ans.isEmpty()){
            res.append(ans.pollFirst());
        }

        return res.toString();
    }
}