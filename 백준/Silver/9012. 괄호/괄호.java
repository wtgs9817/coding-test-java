import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			boolean flag = check(str);
			
			if(flag) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}	
	}
	
	
	public static boolean check(String str) {
		Stack<Character> stk = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				stk.push(str.charAt(i));
			}
			
			else {
				if(!stk.isEmpty()) {
					stk.pop();
				}
				else {
					return false;
				}
			}	
		}
		
		if(!stk.isEmpty()) return false;
		else return true;
		
	}

}
