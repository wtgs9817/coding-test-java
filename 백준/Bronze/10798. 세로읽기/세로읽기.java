import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String[] str = new String[5];
		
		for(int i=0; i<5; i++) {
			str[i] = br.readLine();
		}
		
		
		for(int i=0; i<15; i++) {
			
			for(int k=0; k<5; k++) {
				if(i < str[k].length()) {
					sb.append( String.valueOf(str[k].charAt(i)) );
				}
			}
		}
		
		System.out.println(sb.toString());	
	}

}
