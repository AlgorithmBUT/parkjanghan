import java.util.*;

class Solution {
    
    public int manDistSquare(int startX, int startY, int ballX, int ballY){
        return (int)Math.pow(Math.abs(startY - ballY) , 2) + (int)Math.pow(Math.abs(startX - ballX), 2);
    }
    
    public int calc_square(int m, int n, int startX, int startY, int ballX, int ballY)  {

        int min_dist1 = manDistSquare(startX, startY, ballX*(-1), ballY);
        if (startY == ballY && startX > ballX) min_dist1 = Integer.MAX_VALUE;
            
        int min_dist2 = manDistSquare(startX, startY, ballX, ballY*(-1));
        if (startX == ballX && startY > ballY) min_dist2 = Integer.MAX_VALUE;
        
        int min_dist3 = manDistSquare(startX, startY, ballX, (2*n - ballY));
        if (startX == ballX && startY < ballY) min_dist3 = Integer.MAX_VALUE;
        
        int min_dist4 = manDistSquare(startX, startY, (2*m - ballX), ballY);
        if (startY == ballY && startX < ballX) min_dist4 = Integer.MAX_VALUE;
        
//         System.out.println(min_dist1 + " " +min_dist2 + " " + min_dist3 + " " + min_dist4);
    
        int MIN = Math.min(min_dist1, min_dist2);
        MIN = Math.min(MIN, min_dist3);
        MIN = Math.min(MIN, min_dist4);
        
        return MIN;
    }
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        List<Integer> answer = new LinkedList<>();
        
        int ballX = 0;
        int ballY = 0;
        
        for (int t = 0; t < balls.length; t++){
            ballX = balls[t][0];
            ballY = balls[t][1];
            
            answer.add(calc_square(m, n, startX, startY, ballX, ballY));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}