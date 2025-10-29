import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count =-1;
		
		int idx1 = 0;
		int idx2 = 0;
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k=0; k<9; k++) {
				int num = Integer.parseInt(st.nextToken());	
				
				if(count < num) {
					count = num;
					idx1 = i+1;
					idx2 = k+1;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(idx1 + " " + idx2);
		
	}

}