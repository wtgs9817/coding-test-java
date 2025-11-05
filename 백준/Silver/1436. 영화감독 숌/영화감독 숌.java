import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = Integer.parseInt(br.readLine());
		
		
		int cnt = 1;
		
		int num = 666;
		while(cnt != answer) {
			num+=1;
			String str = String.valueOf(num);
			
			if(str.contains("666")) {
				cnt++;
			}
		}
	
		System.out.println(num);
	}
}