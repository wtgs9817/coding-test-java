import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=1; i<=T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n <= 3) System.out.println(dp[n]);
			else {
				for(int k=4; k<=n; k++) {
					dp[k] = dp[k-1] + dp[k-2] + dp[k-3];
				}
				System.out.println(dp[n]);
			}	
		}

	}
}