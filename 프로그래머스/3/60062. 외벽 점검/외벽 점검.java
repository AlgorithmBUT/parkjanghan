import java.util.*;

class Solution {

    private int answer = Integer.MAX_VALUE;

    // 완성된 친구 순서로 점검
    public void checkOrder(int[] nextDist, int[] dist, int[] order) {
        int weakCount = nextDist.length;

        // 모든 취약 지점을 시작점으로 확인
        for (int start = 0; start < weakCount; start++) {
            int currentNode = start;
            int checkedCount = 0;

            // 정해진 순서대로 친구 투입
            for (int i = 0; i < order.length; i++) {
                int remainDistance = dist[order[i]];

                // 현재 취약 지점에서 출발하므로 바로 점검
                checkedCount++;

                // 이동할 수 있는 동안 다음 취약 지점 점검
                while (checkedCount < weakCount
                        && remainDistance >= nextDist[currentNode]) {

                    remainDistance -= nextDist[currentNode];
                    currentNode = (currentNode + 1) % weakCount;
                    checkedCount++;
                }

                // 모든 취약 지점 점검 완료
                if (checkedCount == weakCount) {
                    answer = Math.min(answer, i + 1);
                    break;
                }

                // 점검하지 못한 다음 취약 지점에서 다음 친구가 출발
                currentNode = (currentNode + 1) % weakCount;
            }
        }
    }

    // 친구들의 투입 순서를 순열로 생성
    public void solve(int[] nextDist, int[] dist, boolean[] visited, int[] order, int depth) {
        if (depth == dist.length) {
            checkOrder(nextDist, dist, order);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            order[depth] = i;

            solve(nextDist, dist, visited, order, depth + 1);

            visited[i] = false;
        }
    }

    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;

        int weakCount = weak.length;
        int[] nextDist = new int[weakCount];

        // 각 취약 지점에서 다음 취약 지점까지의 거리 계산
        for (int i = 0; i < weakCount; i++) {
            int nextIndex = (i + 1) % weakCount;
            nextDist[i] = (weak[nextIndex] - weak[i] + n) % n;
        }

        boolean[] visited = new boolean[dist.length];
        int[] order = new int[dist.length];

        solve(nextDist, dist, visited, order, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}