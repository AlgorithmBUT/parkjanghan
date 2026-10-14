
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int D, W, K;
    static int[][] table;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            table = new int[D][W];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < W; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = D;
            
            dfs(0, 0);

            System.out.println("#" + tc + " " + answer);
        }
    }
    
    public static void dfs(int row, int cnt) {
    	if (cnt >= answer) return;
    	
    	if (row == D) {
    		if (checkTable()) answer = Math.min(cnt, answer);
    		return;
    	}
    	
    	int[] save = table[row].clone();
    	
    	// 1. 해당 행에 약품을 넣지 않음
    	dfs(row + 1, cnt);
    	
    	// 2. 해당 행에 1로 초기화 약품 넣기
    	Arrays.fill(table[row], 1);
    	dfs(row + 1, cnt + 1);
    	
    	// 3. 해당 행에 0으로 초기화 약품 넣기
    	Arrays.fill(table[row], 0);
    	dfs(row + 1, cnt + 1);
    	
    	// 원복
    	table[row] = save;
    	
    }

	private static boolean checkTable() {
		boolean[] colCheck = new boolean[W];
		
		for (int j = 0; j < W; j++) {
			int count = 1;
			for (int i = 1; i < D; i++) {
				if(table[i][j] == table[i-1][j]) {
					count++;
				} else {
					count = 1;
				}
				if (count >= K) {
					colCheck[j] = true;
					break;
				}
			}
		}
		
		for (boolean col : colCheck) {
			if (!col) return false;
		}
		
		return true;
	}

    
}
