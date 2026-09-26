import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution{

    static int TC;
    static int oneDayFee, oneMonthFee, threeMonthFee, oneYearFee;
    static int[] plans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            oneDayFee = Integer.parseInt(st.nextToken());
            oneMonthFee = Integer.parseInt(st.nextToken());
            threeMonthFee = Integer.parseInt(st.nextToken());
            oneYearFee = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            plans = new int[13];
            for (int i = 1; i <= 12; i++){
                plans[i] = Integer.parseInt(st.nextToken());
            }

            int[] fees = new int[13];

            for (int i = 1; i <= 12; i++){
                fees[i] = fees[i-1] + Math.min(plans[i] * oneDayFee, oneMonthFee);
                if (i >= 3) fees[i] = Math.min(fees[i], fees[i-3] + threeMonthFee);
                if (i == 12) fees[i] = Math.min(fees[i], oneYearFee);
            }

            System.out.println("#" + tc + " " + fees[12]);
        }


    }





}