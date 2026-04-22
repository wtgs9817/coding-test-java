import java.util.*;
import java.io.*;


public class Main {
	static int[][] arr;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[4][8];
		
		for(int i=0; i<4; i++) {
			String str = br.readLine();
			for(int k=0; k<8; k++) {
				int n = str.charAt(k)-'0';
				
				arr[i][k] = n;
			}
		}
		
		int spin = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		while(spin > 0) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			n1-=1;
			
			move(n2, n1);
			spin--;
		}
		int cnt = 0;
		
		if(arr[0][0] == 1) cnt++;
		if(arr[1][0] == 1) cnt+=2;
		if(arr[2][0] == 1) cnt+=4;
		if(arr[3][0] == 1) cnt+=8;
		
		System.out.println(cnt);
	}
	
	
		
	static void move(int dir, int idx) {
		int[][] arr2 = new int[4][8];
		
		int[] dirs = new int[4];
		dirs[idx] = dir;
		
		//오른쪽
		for(int i=idx; i<3; i++) {
			if(arr[i][2] != arr[i+1][6]) {
				dirs[i+1] = -dirs[i];
			}
			else break;
		}
		
		//왼쪽
		for(int i=idx; i>0; i--) {
			if(arr[i-1][2] != arr[i][6]) {
				dirs[i-1] = -dirs[i];
			}
			else break;
		}
		
		for(int i=0; i<4; i++) {
			if(dirs[i] != 0) {
				spin(i, dirs[i]);
			}
		}
	}
	
	static void spin(int idx, int dir) {
		int[]temp = new int[8];
		
		//시계
		if(dir == 1) {
			for(int i=0; i<8; i++) {
				int idx2 = (i + 1) % 8;
				temp[idx2] = arr[idx][i];
			}
		}
		
		//반시계
		else {
			for(int i=0; i<8; i++) {
				int idx2 = (i + 7) % 8;
				temp[idx2] = arr[idx][i];
			}
		}
		
		for(int i=0; i<8; i++) {
			arr[idx][i] = temp[i];
		}
	}
	
}