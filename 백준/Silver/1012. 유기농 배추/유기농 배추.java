import java.util.*;
import java.io.*;

//복습
public class Main {
	//동 서 남 북
	static int[] dirX = {1,-1,0,0};
	static int[] dirY = {0,0,1,-1};
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayDeque<int[]> que = new ArrayDeque<>();
			
			int result = 0;
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[y][x];
			boolean[][] visited = new boolean[y][x];
			
			for(int q=0; q<k; q++) {
				st = new StringTokenizer(br.readLine());
				
				int xx = Integer.parseInt(st.nextToken());
				int yy = Integer.parseInt(st.nextToken());
				
				arr[yy][xx] = 1;
				que.offer(new int[]{yy,xx});
			}
			
			for(int[] loc : que) {
				int xx = loc[1];
				int yy = loc[0];
				
				if(arr[yy][xx] == 1 && !visited[yy][xx]) {
					search(xx, yy, visited, arr);
					result++;
				}
			}
			System.out.println(result);
		}
	}
	
	static void search(int xx, int yy, boolean[][] visited, int[][] arr) {
		visited[yy][xx] = true;
		
		for(int i=0; i<4; i++) {
			int lx = xx + dirX[i];
			int ly = yy + dirY[i];
			
			if(lx < 0 || lx >= arr[0].length  || ly < 0 || ly >=arr.length) continue;
			
			if(arr[ly][lx] == 1 && !visited[ly][lx]) {
				visited[ly][lx] = true;
				search(lx, ly, visited, arr);
			}
		}
	}
}