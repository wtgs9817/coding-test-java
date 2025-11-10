import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		while(true) {
			
			String str = br.readLine();
			
			if(str.equals(".")) break;
			
			String answer = check(str);
			System.out.println(answer);
			
		}
		
		
		
		
		
	}
	
	
	public static String check(String str) {
		Stack<Character> stk = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(' || str.charAt(i) == '[') {
				stk.push(str.charAt(i));
			}
			
			if(str.charAt(i) == ')') {
				if(!stk.isEmpty() && stk.peek() == '(') {
					stk.pop();
				}
				else return "no";
			}
			
			if(str.charAt(i) == ']') {
				if(!stk.isEmpty() && stk.peek() == '[') {
					stk.pop();
				}
				else return "no";
			}	
		}

		if(!stk.isEmpty()) return "no";
		else return "yes";
		
		
	}
	
}