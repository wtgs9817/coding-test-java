import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String exp = br.readLine();
		
		String[] strArr = exp.split("-");
		int answer = Integer.MAX_VALUE;
		
		for(String s : strArr) {
			int num = 0;
			
			String[] plus = s.split("\\+");
			for(String s2 : plus) {
				num += Integer.parseInt(s2);
			}
			
			if(answer == Integer.MAX_VALUE) answer = num;
			else {
				answer -= num;
			}
		}
		
		System.out.println(answer);	
	}

}