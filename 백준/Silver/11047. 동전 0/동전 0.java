import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int idx = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num <= K) arr[idx++] = num;
			else continue;
		}
		
		idx-=1;
		int count = 0;
		
		int cnt = 0;
		while(idx>=0) {
			if(K == 0) break;
			
			if(K >= arr[idx] ) {
				count += K/arr[idx];
				K = K % arr[idx];
				idx--;
			}
			else {
				idx--;
				continue;
			}
		}
		
		System.out.println(count);
		
	}
}
