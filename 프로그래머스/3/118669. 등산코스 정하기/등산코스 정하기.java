
import java.util.*;

class Solution {
    static int n;

    static class Vertex implements Comparable<Vertex> {
        int to, intensity;

        Vertex(int to, int intensity) {
            this.to = to;
            this.intensity = intensity;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.intensity, o.intensity);
        }
    }

    static List<Vertex>[] graph;
    static int[] dist;
    static boolean[] isSummit;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Solution.n = n;

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int v1 = path[0];
            int v2 = path[1];
            int intensity = path[2];

            graph[v1].add(new Vertex(v2, intensity));
            graph[v2].add(new Vertex(v1, intensity));
        }

        // 2. 정상 표시
        isSummit = new boolean[n + 1];

        for (int summit : summits) {
            isSummit[summit] = true;
        }

        // 3. 다중 시작점 다익스트라
        dijkstra(gates);

        // 4. intensity가 최소인 정상 선택
        // intensity가 같다면 정상 번호가 작은 것 선택
        Arrays.sort(summits);

        int[] answer = {0, Integer.MAX_VALUE};

        for (int summit : summits) {
            if (dist[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = dist[summit];
            }
        }

        return answer;
    }

    public static void dijkstra(int[] gates) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        // 모든 출입구를 시작점으로
        for (int gate : gates) {
            dist[gate] = 0;
            pq.offer(new Vertex(gate, 0));
        }

        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();

            int now = cur.to;
            int intensity = cur.intensity;

            // 이미 더 좋은 경로가 있다면 무시
            if (dist[now] < intensity) continue;

            // 정상에 도착하면 더 이상 이동하지 않음
            if (isSummit[now]) continue;

            for (Vertex next : graph[now]) {
                int nextIntensity =
                        Math.max(intensity, next.intensity);

                if (nextIntensity < dist[next.to]) {
                    dist[next.to] = nextIntensity;

                    pq.offer(
                        new Vertex(next.to, nextIntensity)
                    );
                }
            }
        }
    }
}
