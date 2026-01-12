import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static boolean[] visited;
	static int N;
	static List<Integer>[] list;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  //정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		int count = 0;
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				search(i);
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	public static void search(int v) {
		visited[v] = true;
		
		for(int n : list[v]) {
			if(!visited[n]) {
				search(n);
			}
		}
	}
}
