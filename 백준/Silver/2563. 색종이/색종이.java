import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		boolean[][] arr = new boolean[100][100];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int w=y; w<y+10; w++) {
				for(int z=x; z<x+10; z++) {
					arr[w][z] = true;
				}
			}
		}
		
		
		int count = 0;
		for(int i=0; i<100; i++) {
			
			for(int k=0; k<100; k++) {
				if(arr[i][k] == true) count++;
			}
		}
		
		System.out.println(count);
	}

}