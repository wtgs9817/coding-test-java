import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[] visited;
	public static int M;
	public static int N;
	public static int[] arr;
	
	
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		arr = new int[M+1];
		
		dfs(0);
		
	}
	
	public static void dfs(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				if(i != M-1) {
					System.out.print(arr[i] + " ");
				}
				else {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}
		
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth+1);
				visited[i] = false;
			}
		}
		
	}

}
