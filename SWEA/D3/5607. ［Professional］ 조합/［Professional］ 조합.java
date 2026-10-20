
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static long fact[] = new long[1_000_001];
	public static long MOD = 1234567891;
	static int N, R;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			fact[0] = 1;
			for (int i = 1; i <= 1_000_000; i++) {
				fact[i] = fact[i-1] * i % MOD;
			}
			
			long numerator = fact[N];
			long denominator = fact[R] * fact[N-R] % MOD;
			
			long inverse = pow(denominator, MOD -2);
			
			long answer = numerator * inverse % MOD;
			
			
			sb.append("#").append(tc).append(" ").append(answer);
			System.out.println(sb);
		}
		
	}
	
	public static long pow(long base, long expo) {
		long result = 1;
		
		while (expo > 0) {
			if (expo % 2 == 1) {
				result = result * base % MOD;
				expo--;
			} 
			
			base = base * base % MOD;
			expo /= 2;
		}
		
		
		return result;
	}
}
