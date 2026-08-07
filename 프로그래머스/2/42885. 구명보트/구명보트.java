import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int front = 0;
        int back = people.length - 1;
        
        while (front <= back) {
            // boat 에 back 태우기
            int remain = limit - people[back];
            // System.out.println("back : " + back);
            back--;
            
            // 남은 공간 안에 탈 수 있는 사람이 있는지 계산
            if (remain >= people[front]) {
                // System.out.println("front : " + front);
                front++;
            }
            
            // 있으면 같이 태우고 내리기
            // System.out.println("-----");
            answer++;
        }
        
        return answer;
    }
}