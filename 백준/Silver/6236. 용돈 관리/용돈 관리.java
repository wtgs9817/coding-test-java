import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int M;
	public static int[] arr;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		arr = new int[N];
		int sum = 0;
		int max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
			max = Math.max(max, arr[i]);
		}

		int answer = check(max, sum);
		System.out.println(answer);
		
	}
	
	public static int check(int max, int sum) {
		int low = max;
		int high = sum;
	
		int answer= 0;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			int num = mid;
			int cnt = 1;
			
			for(int i=0; i<N; i++) {
				if(cnt > M) break;
				
				if(num >= arr[i]) num -= arr[i];
				else {
					num = mid;
					num-=arr[i];
					cnt++;
				}
			}
			
			if(cnt > M) {
				low = mid + 1;
			}
			else {
				answer = mid;
				high = mid - 1;
			}
		}
		
		return answer;
	}

}