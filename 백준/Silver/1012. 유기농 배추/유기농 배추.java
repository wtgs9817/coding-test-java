import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	//상 하 좌 우
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	
	
	static int N,M,K;
	static int[][] map;
	static Queue<int[]> que;
	static boolean[][] visited;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			que = new ArrayDeque<>();
			visited = new boolean[N][M];
	
			int count = 0;
			for(int z=0; z<K; z++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
				que.offer(new int[] {y,x});
			}
			
			for(int[] arr : que) {
				int lx = arr[1];
				int ly = arr[0];
				
				if(!visited[ly][lx]) {
					search(ly, lx);
					count++;
				}
			}
		
			System.out.println(count);
		}
	}
	
	public static void search(int y, int x) {
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int dx = x + X[i];
			int dy = y + Y[i];
			
			if(dx < 0 || dx >= M || dy < 0 || dy >=N) continue;
			if(map[dy][dx] == 1 && !visited[dy][dx]) {
				search(dy,dx);
			}
		}

	}

}
