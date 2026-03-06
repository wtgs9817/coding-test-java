import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[] dist = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		ArrayList<int[]>[] list = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
		}
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new int[] {v,w});
		}
		
		dist[K] = 0;
		que.offer(new int[] {K,0});
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			
			int v = arr[0];
			int w = arr[1];
			if(visited[v]) continue;
			visited[v] = true;
			
			
			for(int[] arr2 : list[v]) {
				int a = arr2[0];
				int b = arr2[1];
				
				if(!visited[a] && dist[a] > dist[v] + b) {
					dist[a] = dist[v] + b;
					que.offer(new int[] {a, dist[a]});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");	
			else sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
}
