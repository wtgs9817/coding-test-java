import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
	
	//북 동 남 서
	static int[] X = {0,1,0,-1};
	static int[] Y = {-1,0,1,0};
	static int count = 0;
	static int N,M;
	static int[][] map;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<M; k++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][k] = a;
			}
		}
	
		System.out.println(countRobot(x,y,dir));
	}
	
	public static int countRobot(int x, int y, int dir) {
		
		int dx = x;
		int dy = y;
		int ddir = dir;
		
		while(true) {
			 if(map[dy][dx] == 0) {
				 count++;
				 map[dy][dx] = 2;
			 }
			 
			boolean flag = false;
			
			for(int i=0; i<4; i++) {
				if(flag) break;
				
				int lx = dx + X[i];
				int ly = dy + Y[i];
				
				if(lx < 0 || lx >=M || ly < 0 || ly >=N) continue;
				if(map[ly][lx] == 0) flag = true;
					
			}
			
			if(flag) {
				ddir = (ddir + 3) % 4;
				
				int xx = dx + X[ddir];
				int yy = dy + Y[ddir];
				
				if(map[yy][xx] == 0) {
					dx = xx;
					dy = yy;	
				}
			}
			else {
				int lx = dx - X[ddir];
				int ly = dy - Y[ddir];
				
				if(lx < 0 || lx >=M || ly < 0 || ly >=N) return count;
				else if(map[ly][lx] == 1) return count;
				else {
					dx = lx;
					dy = ly;
				}
			}		
		}
		
	}
}
