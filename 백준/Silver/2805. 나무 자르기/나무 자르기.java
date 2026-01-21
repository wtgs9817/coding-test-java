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
		
		long min = 0;
		long max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(max < nums[i]) max = nums[i];
		}
		long answer = 0;
		
		while(min<=max) {
			long mid = (min+max)/2;
			long sum = 0;
			
			for(int i=0; i<N; i++) {
				if(nums[i] > mid) sum += (nums[i] - mid);
			}
			
			if(sum >= M) {
				answer = mid;
				min = mid + 1;
			}
			
			else {
				max = mid -1;
			}

		}
		
		System.out.println(answer);
	}
}
