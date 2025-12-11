import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {  //다시 풀어보기
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		sb.append(T);
		
		int idx = T.length()-1;
		while(idx >= 0) {
			
			if(String.valueOf(sb).equals(S)) {
				flag = true;
				break;
			}
			
			if(sb.charAt(idx) == 'A') {
				sb.deleteCharAt(idx);
			}
			
			else {
				sb.deleteCharAt(idx);
				sb.reverse();
			}
			
			idx--;
		}
			
		
		if(flag) System.out.println(1);
		else System.out.println(0);
		
		
	}

}