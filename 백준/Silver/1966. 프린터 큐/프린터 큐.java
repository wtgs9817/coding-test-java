import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<n; k++) {
				arr[k] = Integer.parseInt(st.nextToken());
			}
			
			int count = search(arr, m);
			
			System.out.println(count);
		}
		
		
		
		
		
	}
	
	public static int search(int[] arr, int m) {
		Queue<int[]> que = new ArrayDeque<>();
		int len = arr.length;
		
		
		for(int i=0; i<len; i++) {
			int ipt = len;
			for(int k=0; k<len; k++) {
				if(arr[i] < arr[k]) {
					ipt--;
				}
			}
			que.offer(new int[] {ipt, i});
		}
		
		int count = 1;
		while(!que.isEmpty()) {
			int[] number = que.poll();
			
			boolean flag = false;
			for(int[] numbers : que) {
				if(number[0] < numbers[0]) {
					flag = true;
					break;
				}
			}
			
			if(flag) {
				que.offer(number);
				continue;
			}
			
			if(m == number[1]) {
				break;
			}
			count++;
		}
		
		return count;
		
	}
	

}
