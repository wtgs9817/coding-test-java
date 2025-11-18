import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] strikeArr;
	public static int[] ballArr;
	public static int[] numbers;
	
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		strikeArr = new int[N];
		ballArr = new int[N];
		numbers = new int[N];
		int count = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ans = Integer.parseInt(st.nextToken());
			
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			numbers[i] = ans;
			strikeArr[i] = strike;
			ballArr[i] = ball;
		}
		
		
		for(int i=123; i<=987; i++) {
		
			if(!inValid(i)) continue;
			boolean flag = true;
			for(int k=0; k<N; k++) {
				
				if(getStrike(i, numbers[k]) != strikeArr[k]) {
					flag = false;
					break;
				}
				
				if(getBall(i, numbers[k]) != ballArr[k]) {
					flag = false;
					break;
				}
			}
			if(flag) count++;
		}
		
		System.out.println(count);
	}
	
	public static boolean inValid(int num) {
		String n = String.valueOf(num);
		
		char f = n.charAt(0);
		char s = n.charAt(1);
		char t = n.charAt(2);
		
		if(f == s || s == t || f == t || f == '0' || s == '0' || t == '0') {
			return false;
		}
		return true;
	}
	
	public static int getStrike(int num, int inputNum ) {
		String n = String.valueOf(num);
		String in = String.valueOf(inputNum);
		
		int strike = 0;
		if(n.charAt(0) == in.charAt(0)) strike++;
		if(n.charAt(1) == in.charAt(1)) strike++;
		if(n.charAt(2) == in.charAt(2)) strike++;
		
		return strike;
	}
	
	public static int getBall(int num, int inputNum) {
		String n = String.valueOf(num);
		String in = String.valueOf(inputNum);
		
		int ball = 0;
		
		for(int i=0; i<3; i++) {
			
			for(int k=0; k<3; k++) {
				if(i == k) continue;
				if(in.charAt(i) == n.charAt(k)) ball++;
			}
		}
		
		return ball;
	}

	
	
}
