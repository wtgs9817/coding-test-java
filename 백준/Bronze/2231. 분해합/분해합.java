import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.MinguoChronology;

/*
	분해합 -> 자연수 n과 n을 이루는 각 자리수의 합
	ex) 245 -> (245 + 2 + 4 + 5)  245는 256의 생성자
	
	
	
	n /
	
 
 */
public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strNum = br.readLine();
		int num = Integer.parseInt(strNum);
		
		
		int answer = Integer.MAX_VALUE;
		
		for(int i=1; i<num; i++) {
			int sum = 0;
			int n = i;
			
			while(n != 0) {
				sum += n % 10;
				n /= 10;
			}
			
			if((i+sum) == num) {
				answer = Math.min(answer, i);
			}	
		}
		
		if(answer == Integer.MAX_VALUE) answer = 0;
		
		System.out.println(answer + " ");
		
	}
	
}
