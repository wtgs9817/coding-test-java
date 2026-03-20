import java.util.*;
import java.io.*;


public class Main {
	static int n,m;
	static ArrayList<int[]>[] list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		
		
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new int[] {e,w});
		}
		
		for(int i=1; i<=n; i++) {
			min(i);
		}
		
		System.out.println(sb);		
	}
	
	static void min(int num) {
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		
		for(int i=1; i<=n; i++) dist[i] = Integer.MAX_VALUE;
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> a[1]-b[1]);
		
		que.offer(new int[] {num, 0});
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			int s = arr[0];
			int w = arr[1];
			
			if(visited[s]) continue;
			visited[s] = true;
			
			for(int[] node : list[s]) {
				int s2 = node[0];
				int w2 = node[1];
				
				if(!visited[s2] && dist[s2] > w2 + w) {
					dist[s2] = w2 + w;
					que.offer(new int[] {s2, dist[s2]});
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append(0).append(" ");
			else sb.append(dist[i]).append(" ");
		}
		sb.append("\n");	
	}
}