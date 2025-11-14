import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int n2 = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n2; i++) {
			int num = Integer.parseInt(st.nextToken());
			int low = 0;
			int high = arr.length-1;
			
			boolean flag = false;
			
			while(low <= high) {
				int mid = (low + high)/2;
				
				if(num == arr[mid]) {
					flag = true;
					break;
				}
				
				else if(num < arr[mid]) {
					high = mid - 1;
				}
				
				else if(num > arr[mid]) {
					low = mid + 1;
				}
			}
			
			if(flag) System.out.println(1);
			else System.out.println(0);
			
		}
	}

}