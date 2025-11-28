import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int a = 666;
		int count = 0;
		
		int answer = 0;
		while(true) {
			if(String.valueOf(a).contains("666")) {
				count++;
				if(count == N) {
					answer = a;
					break;
				}
			}
			a++;
		}
		
		System.out.println(answer);

		
	}

}