import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] crews = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++){
            crews[i] = strToInt(timetable[i]);
        }
        
        Arrays.sort(crews);
        
        Queue<Integer> q = new ArrayDeque<>();
        
        int lastCrew = 0;   // 마지막 크루가 탄 시간 기억, Q에서 제거할때 갱신
        
        // 9시 이전 줄세우기
        int crewIdx = 0;
        while(crewIdx < crews.length){
            if (crews[crewIdx] <= 540) {
                q.offer(crews[crewIdx]);
                crewIdx++;
                continue;
            }
            break;
        }
        
        boolean isFull = true;
        
        for (int bus = 0; bus < n; bus++){
            int time = 540 + bus * t;   // 버스 도착 시간
            
            // 해당 시간까지 도착한 크루들 큐에 추가
            while(crewIdx < crews.length){
                if (crews[crewIdx] <= time) {
                    q.offer(crews[crewIdx]);
                    crewIdx++;
                    continue;
                }
                break;
            }
            
            System.out.println(q);
            
            // Q에서 m 크기만큼 크루 제거하기 + 마지막 크루의 시간 기억
            for (int i = 0; i < m; i++){
                if (q.isEmpty()) {
                    isFull = false;
                    break;
                }
                isFull = true;
                int cur = q.peek();
                
                if (cur > time){
                    break;
                }
                
                cur = q.poll();
                lastCrew = cur;
            }
            
        }
        
        System.out.println(isFull);
        int answer = 540 + (n-1) * t;
        if (isFull) answer = lastCrew - 1;

        return intToStr(answer);
    }
    
    public int strToInt(String time){
        String hours = time.substring(0,2);
        String minutes = time.substring(3, 5);
        return Integer.valueOf(hours) * 60 + Integer.valueOf(minutes);
    }
    
    public String intToStr(int time){
        String minutes = String.valueOf(time % 60);
        if (minutes.length() == 1) minutes = "0" + minutes;
        String hours = String.valueOf(time / 60);
        if (hours.length() == 1) hours = "0" + hours;
        
        return hours + ":" + minutes;
    }
}