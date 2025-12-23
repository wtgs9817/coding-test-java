import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)throws IOException {
		/*
		  X가 3으로 나누어 떨어지면, 3으로 나눈다.
		  X가 2로 나누어 떨어지면, 2로 나눈다.
		  1을 뺀다.
		  
		  최소값을 구해라
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		arr[1] = 0; //1부터 시작
		
		for(int i=2; i<=N; i++) {
			arr[i] = arr[i-1] + 1; 
			
			if(i%2 == 0) {
				arr[i] = Math.min(arr[i], arr[i/2] + 1);
			}
			if(i%3==0) {
				arr[i] = Math.min(arr[i], arr[i/3] + 1); 
			}
		}
		
		System.out.println(arr[N]);
		
	}
}
