import java.util.*;
import java.io.*;



public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//오 하 좌 상
		int[] X = {1,0,-1,0};
		int[] Y = {0,1,0,-1};
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] map = new int[N+1][N+1];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			map[y][x] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		
		ArrayDeque<int[]> que = new ArrayDeque<>();
		ArrayDeque<int[]> tails = new ArrayDeque<>();
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			int dir;
			if(str.equals("L")) dir = 2; //왼
			else dir = 3; // 오
			
			que.offer(new int[] {t,dir});
		}
		
		int x = 1;
		int y = 1;
		
		int t = 0;
		int dir = 0;
		
		while(true) {
			t++;
			map[y][x] = 9;
			tails.offer(new int[] {y,x});
			//t초가 끝난 후 방향이동해야 함.
			if(!que.isEmpty() && que.peek()[0] == t-1) {
				int[] arr = que.poll();
				
				int tt = arr[0];
				int dir2 = arr[1];
				
				if(dir2 == 2) {
					dir = (dir + 3) % 4;
				}
				else dir = (dir + 1) % 4;
			}
			
			int dy = Y[dir] + y;
			int dx = X[dir] + x;
			
			if(dx < 1 || dx > N || dy < 1 || dy > N || map[dy][dx] == 9) break;
			if(map[dy][dx] != 1) {
				if(!tails.isEmpty()) {
					int[] arr = tails.poll();
					map[arr[0]][arr[1]] = 0;
				}
			}

			x += X[dir];
			y += Y[dir];
			
		}
		System.out.println(t);
	}
}
