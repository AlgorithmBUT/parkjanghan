import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution{

    static int N, M;
    static int totalCnt;
    static List<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            for (int i = 1; i <= N; i++){
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int g1 = Integer.parseInt(st.nextToken());
                int g2 = Integer.parseInt(st.nextToken());
                graph[g1].add(g2);
                graph[g2].add(g1);
            }

            int[] isSelected = new int[N];
            Arrays.fill(isSelected, -1);
            totalCnt = 0;
            // System.out.println(Arrays.toString(isSelected));
            // -1 : 아직 선택 안됨, 0 : 선택 안함, 1 : 선택함

            combination(0, isSelected);
            System.out.println("#" + tc + " " + totalCnt);
        }

    }

    public static void combination(int cnt, int[] isSelected){
        if (cnt == N){
            totalCnt++;
            // System.out.println(Arrays.toString(isSelected));
            return;
        }

        boolean canSelect = true;
        for (int i : graph[cnt+1]){
            if (isSelected[i-1] == 1) {
                canSelect = false;
                break;
            }
        }

        if (canSelect) {
            isSelected[cnt] = 1;
            combination(cnt + 1, isSelected);
        }

        isSelected[cnt] = 0;
        combination(cnt + 1, isSelected);
    }

}