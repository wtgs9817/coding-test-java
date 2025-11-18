import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static int[][] arr;
	public static boolean[][] visited;
	public static int N;
	
	public static int cnt = 0;
	
	//상 하 좌 우
	public static int[] X = {0,0,-1,1};
	public static int[] Y = {-1,1,0,0};
	
	
	
	
	public static void main(String[] args)throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		List<Integer> list = new ArrayList<>();
		
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int k=0; k<N; k++) {
				arr[i][k] = Integer.parseInt(String.valueOf(str.charAt(k)));
			}
		}
		
		for(int i=0; i<N; i++) {
			
			for(int k=0; k<N; k++) {
				if(!visited[i][k] && arr[i][k] == 1) {
					searchAPT(i,k);
					list.add(cnt);
					cnt = 0; //단지하나를 다 탐색한 뒤 초기화
				}
			}
		}

		
		Collections.sort(list);
		System.out.println(list.size());
		for(int a : list) System.out.println(a);
		
		
	}
	
	public static void searchAPT(int i, int k) {
		visited[i][k] = true;
		cnt++;
		
		int x = k;
		int y = i;
		
		for(int w=0; w<4; w++) {
			int cx = x + X[w];
			int cy = y + Y[w];
			
			if(cx < 0 || cx >=N || cy < 0 || cy >=N) continue;
			
			
			if(!visited[cy][cx] && arr[cy][cx] == 1) {
				searchAPT(cy, cx);
			}
		}
	}
	
}