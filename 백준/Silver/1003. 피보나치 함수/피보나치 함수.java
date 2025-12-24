import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	//두번째 풀이
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) System.out.println(1 + " " + 0 );
			else if(n == 1) System.out.println(0 + " " + 1);
			else {
				int[] arr0 = new int[n+1];
				int[] arr1 = new int[n+1];
				
				arr0[0] = 1;
				arr0[1] = 0;
				
				arr1[0] = 0;
				arr1[1] = 1;
				
				
				for(int k=2; k<=n; k++) {
					arr0[k] = arr0[k-1] + arr0[k-2];
					arr1[k] = arr1[k-1] + arr1[k-2];
				}
				
				System.out.println(arr0[n] + " " + arr1[n]);
			}
			
		}
		
	}

}