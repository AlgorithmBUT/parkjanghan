import java.util.*;

class Solution {
    
    public static int[][] dp;
    static int targetAlp = 0;
    static int targetCop = 0;
    
    public int solution(int alp, int cop, int[][] problems) {
        
        targetAlp = 0;
        targetCop = 0;
        
        for (int[] prob : problems){
            // 모든 problems에 대해서
            targetAlp = Math.max(targetAlp, prob[0]);
            targetCop = Math.max(targetCop, prob[1]);
        }
        
        // System.out.println("target alp : " + targetAlp + " target cop : " + targetCop);
        
        // ????
        alp = Math.min(alp, targetAlp);
        cop = Math.min(cop, targetCop);
        
        // 코딩력 * 알고력 테이블 만들기
        dp = new int[targetAlp + 1][targetCop + 1];
        for (int i = 0; i <= targetAlp; i++){
            Arrays.fill(dp[i], 0);
        }
        
        // 초기값 init
        for (int i = alp; i <= targetAlp; i++){
            for (int j = cop; j <= targetCop; j++){
                dp[i][j] = (i - alp) + (j - cop);
            }
        }
        
        // 각 칸 채우기
        for (int i = alp; i <= targetAlp; i++){
            for (int j = cop; j <= targetCop; j++){
                
                if (i < targetAlp) {
                        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                    }
                    
                if (j < targetCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                for (int[] prob : problems){
                    // 모든 problems에 대해서
                    int alp_req = prob[0];
                    int cop_req = prob[1];
                    int alp_rwd = prob[2];
                    int cop_rwd = prob[3];
                    int cost = prob[4];
                    
                    // 갱신 로직을 변경
                    /*
                        기존 방식 : (i, j) 에서 만약 i - alp_rwd가 alp_req일 때 (i, j) 칸을 업데이트
                        새로운 방식 : (i, j) 에서 i >= alp_req일 경우 (i + req, j) 칸을 업데이트
                            + if (i + alp_rwd <= targetAlp) 인 경우만 업데이트 하면 틀림 -> targetAlp 를 넘어도 숏컷으로 한번에 갈수 있기
                            때문에 해당 경로를 인정해야 함.
                            
                    */
                    
                    // 수정
                    if (i >= alp_req && j >= cop_req) {
                        int nextAlp = Math.min(targetAlp, i + alp_rwd);
                        int nextCop = Math.min(targetCop, j + cop_rwd);
                        
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + cost);
                    }
                }
            }
        }
        
        // printDp();
        
        
        return dp[targetAlp][targetCop];
    }
    
    public static void printDp(){
        for (int i = 0; i <= targetAlp; i++){
            for (int j = 0; j <= targetCop; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}