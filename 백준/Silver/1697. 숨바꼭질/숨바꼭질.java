import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> que = new ArrayDeque<>();
		
		int[] move = {-1, 1, 2};
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		int[] visited = new int[100001];
		que.offer(N);
		
		while(!que.isEmpty()) {
			int n = que.poll();
			
			if(n == M) break;
			
			for(int i=0; i<3; i++) {
				int n2 = n;
				if(move[i] > 1) n2 *= move[i];
				else n2 += move[i];
				
				if(n2 >= 0 && n2 <=100000 && visited[n2] == 0 && n2 != N) {
					visited[n2] = visited[n] + 1;
					que.offer(n2);
				}
			}		
		}
		
		System.out.println(visited[M]);
		
	}
}