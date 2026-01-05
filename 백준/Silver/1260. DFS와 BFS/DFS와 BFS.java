import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static boolean[] visited;
	static boolean[] visited02;
	
	
	static List<Integer>[] list;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	static Queue<Integer> que = new ArrayDeque<>();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()); //시작 정점
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		visited02 = new boolean[N+1];
		
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		que.offer(V);
		visited02[V] = true;
		dfs(V);
		bfs();
		
		
		System.out.println(sb);
		System.out.println(sb2);
		
	}
	
	public static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		
		for(int n : list[v]) {
			if(!visited[n]) {
				dfs(n);
				
			}
		}
	}
	
	public static void bfs() {
		
		while(!que.isEmpty()) {
			int n = que.poll();
			sb2.append(n).append(" ");
			

			for(int a : list[n]) {
				if(!visited02[a]) {
					visited02[a] = true;
					que.offer(a);
	
				}
			}
		}
	}

}