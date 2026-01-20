import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] trg = new int[500][500];
		
		int N = Integer.parseInt(br.readLine());
		
		trg[0][0] = Integer.parseInt(br.readLine());
		
		if(N == 1) System.out.println(trg[0][0]);
		
		else {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			trg[1][0] = Integer.parseInt(st.nextToken()) + trg[0][0];
			trg[1][1] = Integer.parseInt(st.nextToken()) + trg[0][0];
			
			for(int i=2; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int k=0; k<=i; k++) {
					if(k == 0) {
						trg[i][k] = Integer.parseInt(st.nextToken()) + trg[i-1][k];
					}
					else if(k < i){
						trg[i][k] = Integer.parseInt(st.nextToken()) + Math.max(trg[i-1][k-1], trg[i-1][k]);
					}
					
					else {
						trg[i][k] = Integer.parseInt(st.nextToken()) + trg[i-1][k-1];
					}
				}
			}
			int max = trg[N-1][0];
			
			for(int i=0; i<N; i++) {
				max = Math.max(max, trg[N-1][i]);
			}
			System.out.println(max);
		}

	}
}