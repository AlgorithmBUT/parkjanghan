import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws Exception{

        for (int tc = 1; tc <= 10; tc++){
            int test_case = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer( br.readLine());

            Deque<Integer> q = new ArrayDeque<>();

            for (int i = 0; i < 8; i++){
                if (st.hasMoreTokens()) q.offer(Integer.parseInt(st.nextToken()));
            }

            boolean isEnd = false;
            int temp = 3;
            while (!isEnd){
                for (int i = 1; i <= 5; i++){
                    int cur = q.poll();
                    cur = (cur > i)? cur - i : 0;
                    q.offer(cur);

                    if (cur == 0) {
                        isEnd = true;
                        break;
                    }
                }
                // System.out.println(q);
            }

            System.out.print("#" + tc);
            while(!q.isEmpty()){
                System.out.print(" " + q.poll());
            } System.out.println();
        }
    }
}