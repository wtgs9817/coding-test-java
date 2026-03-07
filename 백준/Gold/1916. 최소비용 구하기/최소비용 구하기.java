import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args)throws IOException {
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] list = new ArrayList[N+1];
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new int[] {e,w});
		}
		st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		dist[s] = 0;
		que.offer(new int[] {s,0});
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			
			
			int n = arr[0];
			int c = arr[1];
			if(visited[n]) continue;
			visited[n] = true;
			
			for(int[] num : list[n]) {
				int n2 = num[0];  
				int n3 = num[1];  
				
				if(!visited[n2] && dist[n2] > c + n3 ) {
					dist[n2] = c+n3;
					que.offer(new int[] {n2, dist[n2]});
				}
			}
		}
		
		System.out.println(dist[e]);
	}
}
