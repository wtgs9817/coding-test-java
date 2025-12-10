import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	
	static List<Integer>[] list;
	static boolean[] visited;
	static int N,M, count = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		StringTokenizer st;
		
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
		
		virus(1);
		System.out.println(count);
		
	}
	
	public static void virus(int n) {
		visited[n] = true;
		
		for(int num : list[n]) {
			if(!visited[num]) {
				virus(num);
				count++;
			}
		}
	}
	
	

}