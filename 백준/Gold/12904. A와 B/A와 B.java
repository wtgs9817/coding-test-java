import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		sb.append(T);
		
		while(sb.length() > S.length()) {
			if(sb.charAt(sb.length()-1) == 'A') {
				sb.deleteCharAt(sb.length()-1);
			}
			else {
				sb.deleteCharAt(sb.length()-1);
				sb.reverse();
			}
		}
		T = String.valueOf(sb);
		
		if(T.equals(S)) System.out.println(1);
		else System.out.println(0);
	}
}