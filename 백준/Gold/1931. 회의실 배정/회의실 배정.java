import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
회의의 시작시간과 끝나는 시간이 같을 수도 있다.
*/

//복습
public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] cf = new int[N][2];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			cf[i][0] = s;
			cf[i][1] = e;
		}
		
		Arrays.sort(cf, (a,b) -> {
			if(a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});
		
		int start = 0;
		int count = 0;
		for(int[] arr : cf) {
			int s = arr[0];
			int e = arr[1];
			
			if(start <= s) {
				start = e;
				count++;
			}
		}
		System.out.println(count);
	}

}