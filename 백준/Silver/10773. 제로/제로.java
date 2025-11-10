import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
	
		Stack<Integer> stk = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				sum -= stk.pop();
			}
			else {
				stk.push(n);
				sum += n;
			}
		}
		
		System.out.println(sum);
	}
}