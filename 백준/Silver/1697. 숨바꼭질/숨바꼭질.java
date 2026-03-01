import java.util.*;
import java.io.*;

//복습
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<Integer> que = new ArrayDeque<>();
		int[] move = {-1,1,2};
		
		int N = Integer.parseInt(st.nextToken()); //수빈
		int K = Integer.parseInt(st.nextToken()); //동싱
		
		int[] visited = new int[100001];
		visited[N] = 1;
		que.offer(N);
		
		while(!que.isEmpty()) {
			int subin = que.poll();
			
			if(subin == K) break;
			
			for(int i=0; i<move.length; i++) {
				int a = subin;
				if(i==2) {
					a *= move[i];
				}
				else a += move[i];
				
				if(a >= 0 && a<=100000 && visited[a] == 0) {
					que.offer(a);
					visited[a] = (visited[subin] + 1);
				}
			}					
		}
		
		System.out.println(visited[K] - 1);
				
	}
}