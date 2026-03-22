import java.util.*;
import java.io.*;

//복습
public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int cnt = 0;
	//상 하 좌 우
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int k=0; k<N; k++) {
				int n = str.charAt(k)-'0';
				map[i][k] = n;
			}
		}
		
		for(int i=0; i<N; i++) {
			
			for(int k=0; k<N; k++) {
				if(map[i][k] == 1 && !visited[i][k]) {
					cnt = 1;
					search(i, k);
					que.offer(cnt);
				}
			}
			cnt = 0;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(que.size()).append("\n");
		
		//우선순위 큐는 그냥 반복문으로 돌리면 오름차순 보장X
		//poll()로 하나씩 꺼낼 때만 최솟값 순서로 보장 O
		while(!que.isEmpty()) {
			sb.append(que.poll()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void search(int y, int x) {
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int dx = x + X[i];
			int dy = y + Y[i];
			
			if(dx < 0 || dx >=N || dy < 0 || dy >=N) continue;
			if(map[dy][dx] != 1 || visited[dy][dx]) continue;
			
			cnt++;
			search(dy,dx);
		}	
	}
}