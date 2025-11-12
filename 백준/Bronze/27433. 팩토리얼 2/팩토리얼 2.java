import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long num = 1;
		long answer =fac(n, num);
		
		System.out.println(answer);
		
		
	}
	
	public static long fac(int n, long answer) {
		if(n > 0) {
			return fac(n-1, answer*n);
		}
		
		else {
			return answer;
		}
	}

}