import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//하 우 상 좌
		int[] X = {0,1,0,-1};
		int[] Y = {1,0,-1,0};
		
		int N = Integer.parseInt(br.readLine());
		int answer = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		
		int x = 0;
		int y = 0;
		
		int num = N*N;
		int cnt = 0;
		
		while(num > 0) {
			arr[y][x] = num--;
			
			int ny = y + Y[cnt];
			int nx = x + X[cnt];
			
			if(ny < 0 || ny >=N || nx < 0 || nx >=N || arr[ny][nx] != 0) {
				cnt = (cnt + 1) % 4;
			}
			
			y += Y[cnt];
			x += X[cnt];		
		}
		
		StringBuilder sb = new StringBuilder();
		
		int ax = 0;
		int ay = 0;
		for(int i=0; i<N; i++) {
			
			for(int k=0; k<N; k++) {
				if(arr[i][k] == answer) {
					ax = k;
					ay = i;
				}
				sb.append(arr[i][k]);
				if(k!= N-1) sb.append(" ");
			}
			sb.append("\n");
		}
		
		sb.append(ay+1).append(" ").append(ax+1);
		System.out.println(sb);
	}
}