import java.util.*;
import java.io.*;

/*
 n개의 도시(1<=n<=1000)
 m개의 간선(1<=m<=100000) 2차원 배열로 하면 터짐
 제시되는 A에서 B로 가는 최소 비용을 구해라 항상 시작점에서 도착점으로 가는 경로는 존재함.
  
  복습
 */
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (a[1]-b[1]));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		
		ArrayList<int[]>[] list = new ArrayList[n+1];
	    int[] dist = new int[n+1];
	    boolean[] visited = new boolean[n+1];
	    
	    for(int i=1; i<=n; i++) {
	    	dist[i] = Integer.MAX_VALUE;
	    	list[i] = new ArrayList<>();	    	
	    }
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new int[] {e,w});
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		q.offer(new int[] {s,0});
		
		int[] arr = new int[n+1];
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			
			int n1 = loc[0];
			int w1 = loc[1];
			
			if(n1 == e) break;
			if(visited[n1]) continue;
			
			visited[n1] = true;
			
			for(int[] node : list[n1]) {
				int n2 = node[0];
				int w2 = node[1];
				
				if(!visited[n2] && dist[n2] > w1 + w2) {
					dist[n2] = w1+w2;
					q.offer(new int[] {n2, dist[n2]});
					arr[n2] = n1;
				}				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> stk = new ArrayDeque<>();
		sb.append(dist[e]).append("\n");
		
		stk.push(e);
		int cnt =1;
		int node = e;
		while(true) {
			int a = arr[node];
			
			if(a == 0) break;
			stk.push(a);
			node = a;
			cnt++;	
		}
		
		sb.append(cnt).append("\n");
		
		for(int a : stk) {
			sb.append(a).append(" ");
		}
		
		System.out.println(sb);
	}
}