import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int M,N;
	
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		dfs(0);
		System.out.println(sb);
		
		
	}
	
	public static void dfs(int depth) {
		if(depth == N) {
			for(int i=0; i<N; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=1; i<=M; i++) {
				arr[depth] = i;
				dfs(depth+1);
		}
		
	}
}
