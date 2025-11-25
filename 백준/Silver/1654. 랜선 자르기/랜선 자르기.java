import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long answer = 0;
		int[] arr = new int[N];
		long high = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(high < arr[i]) high = arr[i];
		}
		
		
		long low = 1;
		
		while(low <= high) {
			long mid = (low + high)/2;
			int count = 0;
			
			
			for(int a : arr) {
				count += (a/mid);
			}
			
			
			if(count < M) {
				high = mid -1;	
			}
			
			else if(count >= M) {
				answer = mid;
				low = mid +1;
				
			}
		}
		
		System.out.println(answer);
	}

}
