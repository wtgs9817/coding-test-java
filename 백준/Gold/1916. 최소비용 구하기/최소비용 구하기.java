import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static List<Node>[] list;
	public static int[] dist;
	public static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, cost));
			
		}
		st = new StringTokenizer(br.readLine());
		
		int point1 = Integer.parseInt(st.nextToken());
		int point2 = Integer.parseInt(st.nextToken());
		
		pq.offer(new Node(point1, 0));
		dist[point1] = 0;
		
		int answer = minSearch(point1, point2);
		System.out.println(answer);
	}
	
	public static int minSearch(int point1, int point2) {
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int nowPoint = node.end;
			int nowCost = node.cost;
			
			if(nowPoint == point2) return dist[nowPoint];
			
			for(Node n : list[nowPoint]) {
				int totalCost = dist[nowPoint] + n.cost;
				if(dist[n.end] > totalCost ) {
					dist[n.end] = totalCost;
					pq.offer(new Node(n.end, totalCost));
				}
				else continue;
			}
		}
		
		return dist[point2];	
	}
	
	
	
	
	
	
	
	
	
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	
}