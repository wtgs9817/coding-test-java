import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
  G -> 현재 몸무게^2 - 기억하고 있는 몸무게^2
  G는 100,000보다 작거나 같은 자연수	
  범위 잘보고 문제 잘 읽고 풀기
 */
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		List<Long> list = new ArrayList<>();

		long start = 1;
		long end = 2;
		
		
		while(true) {
			long s = (long) Math.pow(start, 2);
			long e = (long) Math.pow(end, 2);
			if((end-start) == 1 && e-s > G ) break;
			long result = e-s;

			if(result == G) {
				list.add(end);
				start++;
				end++;	
			}
			
			else if(result < G) end++;
			else start++;
		}
		
		if(list.isEmpty()) System.out.println(-1);
		else {
			Collections.sort(list);
			for(long a : list) System.out.println(a);
		}
	}
}