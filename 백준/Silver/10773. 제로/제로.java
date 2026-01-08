import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[K];
		
		int idx = 0;
		int sum = 0;
		for(int i=0; i<K; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n != 0) {
				arr[idx++] = n;
				sum+= n;
			}
			else {
				sum-=arr[--idx];
				arr[idx] =0;
			}
		}
		System.out.println(sum);
	}
}