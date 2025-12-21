import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<N; i++) {
			
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0 ) {
				System.out.println(1 + " " + 0);
				continue;
			}
			
			else if(num == 1) {
				System.out.println(0 + " " + 1);
				continue;
			}
			
			
			int[] zero = new int[num+1];
			int[] one = new int[num+1];
			
			zero[0] = 1;
			zero[1] = 0;
			
			one[0] = 0;
			one[1] = 1;
			
			
			for(int k=2; k<=num; k++) {
				zero[k] = zero[k-1] + zero[k-2];
				one[k] = one[k-1] + one[k-2];
			}
			
			System.out.println(zero[num] + " " + one[num]);
		}	
	}
}