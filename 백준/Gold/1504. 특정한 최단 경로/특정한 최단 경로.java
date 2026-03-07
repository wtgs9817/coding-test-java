import java.util.*;
import java.io.*;

public class Main {
	static int N,E;
	static int min = Integer.MAX_VALUE;
	static ArrayList<int[]>[] list; 
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new int[] {e,w});
			list[e].add(new int[] {s,w});
		}
		
		st = new StringTokenizer(br.readLine());
		int m1 = Integer.parseInt(st.nextToken());
		int m2 = Integer.parseInt(st.nextToken());
		
		int[][] result = new int[3][N+1];
		result[0] = minSearch(1);
		result[1] = minSearch(m1);
		result[2] = minSearch(m2);
		
		//1 -> m1 -> m2 -> N
		long min1 = (long) result[0][m1] + result[1][m2] + result[2][N];
		
		//1 -> m2 -> m1 -> N
		long min2 = (long)result[0][m2] + result[2][m1] + result[1][N];
		long answer = Math.min(min1, min2);
		
		System.out.println(answer >= Integer.MAX_VALUE ? -1 : answer);
	}
	
	public static int[] minSearch(int start) {
		int[] dist = new int[N+1];
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
		boolean[] visited = new boolean[N+1];
		
		
		que.offer(new int[] {start, 0});
		
		for(int i=1; i<=N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			
			int n = arr[0];
			int w = arr[1];
			
			if(visited[n]) continue;
			visited[n] = true;
			
			
			for(int[] a : list[n]) {
				int n2 = a[0];
				int w2 = a[1];
				
				if(!visited[n2] && dist[n2] > w + w2) {
					dist[n2] = w + w2;
					que.offer(new int[] {n2, dist[n2]});
				}
			}
		}
		return dist;
	}
}
