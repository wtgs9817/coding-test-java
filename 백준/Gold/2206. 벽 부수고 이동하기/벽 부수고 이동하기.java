import java.util.*;
import java.io.*;

/*
 N X M 행렬의 맵 0은 이동 가능 1은 이동 불가 (1,1)부터 시작 (N,M)까지 이동하려고 함
 최단 경로로 이동해야 함. 시작과 끝도 카운트 
 이동 중 한 개의 벽을 부수고 이동하는 게 좀 더 경로가 짧아진다면, 벽을 한 개까지 부수고 이동해도 됨. 상 하 좌 우로 이동 가능 
 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)
 최단 거리 출력이 불가능할 때 -1
 */


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] X = {0,0,-1,1};  //상 하 좌 우
		int[] Y = {-1,1,0,0};  //상 하 좌 우
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		int[][][] dist = new int[N+1][M+1][2];
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int k=1; k<=M; k++) {
				int n = str.charAt(k-1) - '0';
				map[i][k] = n;
				dist[i][k][0] = -1;  //벽 조지고 드감
				dist[i][k][1] = -1;	 // 안 조지고 드감
			}
		}
		
		ArrayDeque<int[]> que = new ArrayDeque<>();
		
		que.offer(new int[] {1,1,0});
		dist[1][1][0] = 1;
		
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			
			int lx = loc[1];
			int ly = loc[0];
			int broke = loc[2]; // 0 안부심 1 부심
			
			if(lx == M && ly == N) {
				System.out.println(dist[N][M][broke]);
				return;
			}
			
			for(int z=0; z<4; z++) {
				int dx = lx + X[z];
				int dy = ly + Y[z];
				
				if(dx < 1 || dx >=M+1 || dy < 1 || dy >=N+1) continue;
				
				if(map[dy][dx] == 0 && dist[dy][dx][broke] == -1) {
					dist[dy][dx][broke] = dist[ly][lx][broke] + 1;
					que.offer(new int[] {dy,dx,broke});
				}
				
				if(map[dy][dx] == 1 && broke == 0 && dist[dy][dx][1] == -1) {
					dist[dy][dx][1] = dist[ly][lx][0] + 1;
					que.offer(new int[] {dy,dx,1});
				}
			}
		}
		
		System.out.println(-1);
			
	}
}
