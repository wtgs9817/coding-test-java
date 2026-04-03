import java.util.*;
import java.io.*;

//복습
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//하 우 상 좌
		int[] X = {0,1,0,-1};
		int[] Y = {1,0,-1,0};
		
		int N = Integer.parseInt(br.readLine());
		int result = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int num = N*N;
		
		int x = 0,y = 0;
		int cnt = 0;
		
		while(num > 0) {
			arr[y][x] = num--;
			
			int fy = y + Y[cnt];
			int fx = x + X[cnt];
			
			if(fy < 0 || fy >= N || fx < 0 || fx >=N || arr[fy][fx] != 0) {
				cnt = (cnt + 1) % 4;
			}
			
			y += Y[cnt];
			x += X[cnt];
		}
		
		int ax = 0;
		int ay = 0;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			
			for(int k=0; k<N; k++) {
				if(result == arr[i][k]) {
					ay = i;
					ax = k;
				}
				if(k != k-1) sb.append(arr[i][k]).append(" ");
				else sb.append(arr[i][k]);
			}
			sb.append("\n");
		}
		
		sb.append(ay+1).append(" ").append(ax+1);
		
		System.out.println(sb);
	}
}
