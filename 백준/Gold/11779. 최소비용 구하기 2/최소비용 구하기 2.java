import java.util.*;
import java.io.*;

//복습
//다익스트라에 대해서 정확히 이해했지만 사소한 실수로 자꾸 틀림. 문제 풀 때 확인 잘 해야할듯

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<int[]>[] list = new ArrayList[n+1];
		boolean[] visited = new boolean[n+1];
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> (a[1]-b[1]));
		int[] dist = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		StringTokenizer st ;
		for(int i=0; i<m; i++) {
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
		int[] save = new int[n+1];
		
		que.offer(new int[] {s,0});
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			
			int node = arr[0];
			int w = arr[1];
			
			if(visited[node]) continue;
			if(node == e) break;
			visited[node] = true;
			
			for(int[] arr2 : list[node]) {
				int node2 = arr2[0];
				int w2 = arr2[1];
				
				if(!visited[node2] && dist[node2] > w + w2) {
					dist[node2] = w + w2;
					que.offer(new int[] {node2, dist[node2]});
					save[node2] = node;
				}
			}
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int fe = e;
		q.push(fe);
		while(true) {
			if(save[fe] == 0) break;
			q.push(save[fe]);
			fe = save[fe];
		}
		int cnt = q.size();
		
		StringBuilder sb = new StringBuilder();
		sb.append(dist[e]).append("\n");
		sb.append(cnt).append("\n");
		
		while(!q.isEmpty()) {
			sb.append(q.pop()).append(" ");
		}
		
		System.out.println(sb);
	}
}
