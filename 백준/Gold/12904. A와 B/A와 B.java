import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//조건을 잘봐야 함. 절대로 정방향으로는 못품
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		int answer = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append(t);
		
		while(s.length() < sb.length()) {
			if(sb.charAt(sb.length()-1) == 'A') {  
				sb.deleteCharAt(sb.length()-1);
			}
			
			else if(sb.charAt(sb.length()-1) == 'B') {
				sb.deleteCharAt(sb.length()-1);
				sb.reverse();
			}
		}
		
		if(String.valueOf(sb).equals(s)) {
			System.out.println(1);
		}
		
		else {
			System.out.println(0);
		}
	}

}