import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26];
		for(int i=0; i<26; i++) {
			arr[i] = -1;
		}
		
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			
			if(arr[idx] == -1) {
				arr[idx] = i;
			}
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(arr[i] + " ");
		}	
	}

}
