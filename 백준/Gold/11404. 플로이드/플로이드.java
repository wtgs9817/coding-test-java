import java.util.*;
import java.io.*;


public class Main {
	static int N;
	static int M;
	static ArrayList<int[]>[] list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[a].add(new int[] {b,w});
		}
		
		for(int i=1; i<=N; i++) {
			search(i);
		}
		
		System.out.println(sb);
		
	}
	
	static void search(int i) {
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> a[1]-b[1]);
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		
		for(int k=1; k<=N; k++) {
			dist[k] = Integer.MAX_VALUE;
		}
		dist[i] = 0;
		
		
		que.offer(new int[] {i,0});
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			
			int n1 = arr[0];
			int w1 = arr[1];
			
			if(visited[n1]) continue;
			visited[n1] = true;
			
			for(int[] narr : list[n1]) {
				int n2 =narr[0];
				int w2 = narr[1];
				
				if(!visited[n2] && dist[n2] > w1 + w2 ) {
					dist[n2] = w1 + w2;
					que.offer(new int[] {n2, dist[n2]});
				}
			}
		}
		
		for(int k=1; k<=N; k++) {
			if(dist[k] == Integer.MAX_VALUE) dist[k] = 0;
			sb.append(dist[k]);
			if(k<N) sb.append(" ");
		}
		sb.append("\n");		
	}
}