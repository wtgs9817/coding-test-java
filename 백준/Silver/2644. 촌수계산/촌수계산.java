import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	public static List<Integer>[] list;
	public static Queue<int[]> que = new ArrayDeque<>();
	public static boolean[] visited;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int f1 = Integer.parseInt(st.nextToken());
		int f2 = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		que.offer(new int[] {f1,0});
		visited[f1] = true;
		int answer = familyCount(f2);
		System.out.println(answer);
		
		
	}
	
	public static int familyCount(int f2) {
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			
			int loc = arr[0];
			int cost = arr[1];
			
			visited[loc] = true;
			
			if(loc == f2) {
				return cost;
				
			}
			for(int a : list[loc]) {
				if(!visited[a]) {
					que.offer(new int[] {a, cost+1});
				}
			}
		}
		
		return -1;
	}
}