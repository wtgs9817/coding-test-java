import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int[][] arr;
	
	//상 하 좌 우
	static int[] X = {0, 0, -1, 1};
	static int[] Y = {-1, 1, 0, 0};
	
	static int x,y,k;
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			int count = 0;
			Queue<int[]> que = new ArrayDeque<>();
			arr = new int[y][x];
			boolean[][] visited = new boolean[y][x];
			
			for(int q=0; q<k; q++) {
				st = new StringTokenizer(br.readLine());
	
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				que.offer(new int[] {a,b});
				arr[b][a] = 1;
			}
			for(int[] loc : que) {
				if(!visited[loc[1]][loc[0]]) {
					search(loc, visited);
					count++;
				}
			}
			System.out.println(count);			
		}
	}
	
	public static void search(int[] loc, boolean[][] visited) {
		int lx = loc[0];
		int ly = loc[1];
		visited[ly][lx] = true;
		
		for(int i=0; i<4; i++) {
			int dx = lx + X[i];
			int dy = ly + Y[i];
			
			if(dx < 0 || dx >= x || dy < 0 || dy >= y) continue;
			
			if(arr[dy][dx] == 1) {
				if(!visited[dy][dx]) {
					search(new int[] {dx,dy}, visited);
				}
			}
		}	
	}
}
