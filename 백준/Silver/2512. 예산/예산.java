import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 모든 요청 가능 - 요청한 금액 배정
	 모든 요청 X - 상한액 정해놓고 그 금액을 넘기면 다 상한액 상한액 이하는 다 요청금액으로
	 
	 
	 */
	
	public static int budgetCheck(int[] arr, int budget, int sum, int max) {
		
		int answer = 0;
		
		if(sum <= budget) {
			return max;
		}
		
		else { 
			int low = 0;
			int high = max;
			
			while(low <= high) {
				int mid = (low + high) /2;
				
				sum = 0;
				
				for(int i=0; i<arr.length; i++) {
					if(mid <= arr[i]) {
						sum += mid;
					}
					else {
						sum += arr[i];
					}
				}
				
				
				if(sum > budget) {
					high = mid-1;
				}
				
				else {
					answer = Math.max(answer, mid);
					low = mid + 1;
				}		
			}
		}
		
		return answer;
	}
	
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		int sum = 0;
		int max = 0;
		
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			max = Math.max(max, arr[i]);
		}
		
		
		int budget = Integer.parseInt(br.readLine());
		int answer = budgetCheck(arr, budget, sum, max);
		System.out.println(answer);
		
	}
}
