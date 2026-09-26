import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

class Solution{

    static int TC;
    static int N;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++){
            N = sc.nextInt();

            int before = sc.nextInt();
            int answer = 0;
            int saved = 0;

            int count = 0;

            for (int i = 1; i < N; i++){
                int newHeight = sc.nextInt();

                if (before < newHeight){
                    count++;
                } else {
                    if (count != 0) {
                        saved = count;
                    }
                    answer += saved;
                    count = 0;
                }

                before = newHeight;

            }

            System.out.println("#" + tc + " " + answer);
        }

    }





}