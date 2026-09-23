import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        List<Edge>[] graph = new ArrayList[n+1];
        
        for (int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares){
            int n1 = fare[0];
            int n2 = fare[1];
            int weight = fare[2];
            graph[n1].add(new Edge(n2, weight));
            graph[n2].add(new Edge(n1, weight));
        }
        
        // for (int i = 0; i <= n; i++){
        //     System.out.println( i + " " + graph[i]);
        // }
        
        int distS[] = dijkstra(s, graph, n);
        int distA[] = dijkstra(a, graph, n);
        int distB[] = dijkstra(b, graph, n);
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++){
            int sum = distS[i] + distA[i] + distB[i];
            answer = Math.min(sum, answer);
        }
        
        return answer;
    }
    
    public static int[] dijkstra(int start, List<Edge>[] graph, int n){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cost, n2.cost));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            System.out.println(cur.num + " : " + cur.cost);
            
            if (cur.cost > dist[cur.num]) continue;
            
            for (Edge next : graph[cur.num]) {
                int newCost = cur.cost + next.weight;
                if (dist[next.to] > newCost) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
            
        }
        
        return dist;
    }
    
    public static class Node {
        int num;
        int cost;
        public Node (int num, int cost){
            
            this.num = num;
            this.cost = cost;
        }
    }
    
    public static class Edge {
        int to;
        int weight;
        
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        
        public String toString(){
            return "[ to : " + to + " , weight : " + weight + " ]"; 
        }
    }
}