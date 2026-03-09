import java.util.*;
import java.io.*;


/*
  도시 최대 1000개
  한 도시 출발 다른 도시 도착하는 버스 최대 100,000개
  
  
 
 */
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		ArrayList<int[]>[] list = new ArrayList[N+1];
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
		
		StringTokenizer st;
		int[] prev = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		
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
		
		que.offer(new int[] {s,0});
		dist[s] = 0;
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			
			int a = arr[0]; 
			int b = arr[1];
			
			if(a == e) break;
			if(visited[a]) continue;
			visited[a] = true;
			
			for(int[] n : list[a]) {
				int a2 = n[0];
				int b2 = n[1];
				
				if(!visited[a2] && dist[a2] > b2 + b) {
					dist[a2] = b2+b;
					que.offer(new int[] {a2, dist[a2]});
					prev[a2] = a;
				}
			}		
		}
		
		int ds = e;
		int cnt = 0;
		ArrayList<Integer> result = new ArrayList<>();
		result.add(ds);
		while(true) {			
			
			int num = prev[ds];
			if(num == 0 ) break;
			result.add(num);
			ds = num;
			cnt++;			
		}
		
		Collections.reverse(result);
		
		for(int node : result) {
			sb.append(node).append(" ");
		}
		
		
		System.out.println(dist[e]);
		System.out.println(cnt+1);
		System.out.println(sb);
	}

}
