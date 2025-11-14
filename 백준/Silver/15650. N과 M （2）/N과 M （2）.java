import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int M,N;
	public static boolean[] visited;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		visited = new boolean[M+1];
		arr = new int[N+1];
		
		dfs(0,1);
		System.out.println(sb);
		
		
	}
	
	
	public static void dfs(int depth, int start) {
		
		if(depth == N) {
			for(int i=0; i<N; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=start; i<=M; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth+1, i);
				visited[i] = false;
			}
		}
	}
}