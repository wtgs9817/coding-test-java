import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] top = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			int n = Integer.parseInt(st.nextToken());
			top[i] = n;
		}
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			int n = top[i];
			while(!q.isEmpty()) {
				if(q.peek()[0] < n) q.pop();
				else {
					arr[i] = q.peek()[1];
					break;
				}
			}
			q.push(new int[] {n, i});
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) sb.append(arr[i]).append(" ");
		
		System.out.println(sb);
	}
}