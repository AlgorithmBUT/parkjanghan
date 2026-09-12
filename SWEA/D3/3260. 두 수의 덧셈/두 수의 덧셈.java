import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Solution{

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int carry = 0;
            int aIndex = a.length() - 1;
            int bIndex = b.length() - 1;

            StringBuilder sb = new StringBuilder();

            while (aIndex >= 0 || bIndex >= 0){
                int aNum = (aIndex >= 0)? a.charAt(aIndex) - '0' : 0;
                int bNum = (bIndex >= 0)? b.charAt(bIndex) - '0' : 0;

                // System.out.println("aNum : " + aNum + " bNum : " + bNum + " carry : " + carry);
                int sum = aNum + bNum + carry;
                carry = sum / 10;
                sb.append(sum % 10);

                aIndex--;
                bIndex--;
            }

            if (carry > 0) sb.append(carry);

            System.out.print("#"+ tc + " ");
            System.out.println(sb.reverse());
        }

    }
}