import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[N+1];
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		ArrayDeque<Integer> que = new ArrayDeque<>();
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		int[] arr = new int[N+1];
		arr[1] = -1;
		que.offer(1);

		while(!que.isEmpty()) {
			int n = que.poll();
			
			for(int a : list[n]) {
				if(arr[a] == 0) {
					arr[a] = n;
					que.offer(a);
				}
			}
		}
		

		for(int i=2; i<=N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}