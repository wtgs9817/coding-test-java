import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int N,M,K,X;  //도시의 개수, 도로의 개수, 거리 정보, 출발 도시의 번호
	public static List<Integer>[] list;
	public static int[] dist;
	public static Queue<Integer> que = new ArrayDeque<>();
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		
		search(X);
		boolean flag = false;
		for(int i=1; i<=N; i++) {
			if(dist[i] == K) {
				flag = true;
				System.out.println(i);
			}
		}
		
		if(!flag) System.out.println(-1);
	
		
	}
	
	public static void search(int x) {
		que.offer(x);
		dist[x] = 0;
		
		while(!que.isEmpty()) {
			int end = que.poll();
			
			for(int a : list[end]) {
				if(dist[a] > 1 + dist[end]) {
					dist[a] = 1+dist[end];
					que.offer(a);
				}
			}
		}
	}

}