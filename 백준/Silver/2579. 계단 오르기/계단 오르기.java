import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다.
첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

*/
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] answer = new int[301];
		
		
		int[] scores = new int[301];
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		answer[1] = scores[1];
		answer[2] = answer[1] + scores[2];
		answer[3] = Math.max((answer[1] + scores[3]), (scores[2]+scores[3]));
			
		for(int i=4; i<=N; i++) {
			answer[i] = Math.max((answer[i-3] + scores[i-1] + scores[i]), (answer[i-2] + scores[i]) ); 
		}
		
		System.out.println(answer[N]);
	}
}