
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int min = 0;
		int max = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max += arr[i];
			if(arr[i] > min) min = arr[i];
		}
		int num = max;
		int result = 0;
		
		while(min <= max) {
			int mid = (min + max) / 2;
			int count = 0;
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(sum + arr[i] > mid) {
					count++;
					sum = 0;
				}
				sum += arr[i];
			}
			if(sum > 0 ) count++;
			
			if(count <= M) {
				result = mid;
				max = mid - 1;
			}
			else {
				min = mid + 1;
			}
			
		}
		
		System.out.println(result);
	
	}

}