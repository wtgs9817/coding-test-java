import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static int N;
	
	public static List<Integer>[] list;
	public static List<Integer> answer = new ArrayList<>();
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //도시의 개수
		int M = Integer.parseInt(st.nextToken()); //도로의 개수
		int K = Integer.parseInt(st.nextToken()); //거리 정보
		int X = Integer.parseInt(st.nextToken()); //출발 도시 번호
		
		list = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);		
		}
		
		search(K,X);
		Collections.sort(answer);
		
		if(answer.isEmpty()) System.out.println(-1);
		
		for(int num  : answer) {
			System.out.println(num);
		}
		
	}
	
	public static void search(int k, int x) {
		Queue<int[]> que = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		que.offer(new int[] {0,x});
		visited[x] = true;
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			int cost = arr[0];
			int end = arr[1];
			
			
			if(cost == k) {
				answer.add(end);
				continue;
			}
	
			for(int a : list[end]) {
				if(!visited[a]) {
					visited[a] = true;
					que.offer(new int[] {cost+1, a});
				}			
			}				
		}
	}

}