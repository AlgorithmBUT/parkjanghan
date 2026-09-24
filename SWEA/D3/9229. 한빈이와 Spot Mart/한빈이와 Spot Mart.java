import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.nio.file.Files.move;

class Solution{

    public static int TC;
    public static int N, M;

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[] snacks = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i<N; i++){
                snacks[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(snacks);

            int left = 0;
            int right = N-1;
            int maxSum = -1;

            while (left != right){
                int sum = snacks[left] + snacks[right];
                // System.out.println(sum);
                if (sum <= M) {
                    maxSum = Math.max(sum, maxSum);
                    left++;
                } else {
                    right--;
                }
            }


            System.out.println("#" + tc + " " + maxSum);
        }
    }



}