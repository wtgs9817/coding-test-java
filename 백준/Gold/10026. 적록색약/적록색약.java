import java.util.*;
import java.io.*;


public class Main {
	//상 하 좌 우
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	static char[][] map;
	static char[][] map2;
	static int N;
	static boolean[][] visited;
	static boolean[][] visited2;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		map2 = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int k=0; k<N; k++) {
				char c = str.charAt(k);
				map[i][k] = c;
				map2[i][k] = c;
				
			}
		}
		
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		int cnt = 0;
		int cnt2= 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			
			for(int k=0; k<N; k++) {
				if(!visited[i][k]) {
					search(i,k,0);
					cnt++;
					if(map[i][k] == 'B') cnt2++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int k=0; k<N; k++) {
				if(!visited2[i][k]) {
					search(i,k,1);
					cnt2++;
				}
			}
		}
		
		sb.append(cnt).append(" ").append(cnt2);
		System.out.println(sb);
		
	}
	
	static void search(int y, int x, int flag) {
		int ly = y;
		int lx = x;
		int f = flag;
		
		if(f == 0) {
			if(map[ly][lx] == 'B') {
				visited[ly][lx] = true;
				visited2[ly][lx] = true;
			}
			else visited[ly][lx] = true;
			
			for(int i=0; i<4; i++) {
				int dx = lx + X[i];
				int dy = ly + Y[i];
				
				if(dx < 0 || dx >=N || dy < 0 || dy >=N) continue;
				
				if(!visited[dy][dx] && (map[ly][lx] == map[dy][dx])) search(dy,dx,0);
			}
		}
		else {
			visited2[ly][lx] = true;
			
			for(int i=0; i<4; i++) {
				int dx = lx + X[i];
				int dy = ly + Y[i];
				
				if(dx < 0 || dx >=N || dy < 0 || dy >=N) continue;
				
				if(!visited2[dy][dx]) search(dy,dx,1);
			}
		}
	}
}
