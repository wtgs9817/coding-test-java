import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	  MN개의 단위 정사각형으로 나누어져 있는 MxN 크기의 보드에서 어떤 정사각형은 검은색으로 나머지는 흰색으로 칠해져 있음.
	  해당 보드를 잘라서 8x8 크기의 체스판으로 만들려고 함.
	  체스판은 검/흰으로 번갈아서 칠해져 있음. 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 함.(조건에 따르면 하나는 맨 왼쪽 위칸이 흰색인 경우, 하나는 검은색인 경우임)
	 
	 */
	
	
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		
		char[][] arr = new char[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			
			for(int k=0; k<m; k++) {
				arr[i][k] = str.charAt(k);
			}
		}
		
		
		for(int i=0; i<= n-8; i++) {
			for(int k=0; k<=m-8; k++) {
				
				int cntW = 0;   //시작점이 W
				int cntB = 0;   //시작점이 B 
				
				for(int a=0; a<8; a++) {
					for(int b=0; b<8; b++) {
						char ch = arr[i+a][k+b];
						
						if((a+b)%2 == 0) {
							if(ch != 'W') cntW++;
							if(ch != 'B') cntB++;
						}
						else {
							if(ch != 'B') cntW++;
							if(ch != 'W') cntB++;
						}				
					}
				}
				
				min = Math.min(min, Math.min(cntW, cntB));
			}
		}
		
		
		System.out.println(min);
		
	}

}
