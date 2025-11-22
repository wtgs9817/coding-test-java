import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		
		int ans = 0;
		String dna = "TAGC";
		for(int i=0; i<M; i++) {
			int[] cnt = new int[4];
			int max = 0;
			int idx = 0;
			
			
			for(int k=0; k<N; k++) {
				char a = arr[k].charAt(i);
				
				if(a == 'T') cnt[0]++;
				if(a == 'A') cnt[1]++;
				if(a == 'G') cnt[2]++;
				if(a == 'C') cnt[3]++;
			}
			
			for(int k=0; k<4; k++) {
				if(max < cnt[k]) {
					max = cnt[k];
					idx = k;
				}
				
				else if(max == cnt[k]) {
					if(dna.charAt(idx) < dna.charAt(k)) continue;
					else {
						max = cnt[k];
						idx = k;
					}
				}
			}
			
			sb.append(dna.charAt(idx));
			ans = ans + (N - max);
		}
		
		System.out.println(sb);
		System.out.println(ans);
		 
		
		
	}
}
