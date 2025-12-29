import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1번 != 2번
n번 != n-1번
i(2<=i<=n-1)번 집의 색은 i-1번, i+1번 집과 달라야 함.

그리디 : 지금 당장 최선의 선택을 하자 (현재 선택이 미래에 영향 없음)
dp : 모든 경우를 기록해두고, 나중에 최선을 고르자 (현재 선택이 미래 선택을 제한함)

 */
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] result = new int[N+1][4];
		int[] cost = new int[4];
		for(int i=1; i<=3; i++) {
			result[1][i] = Integer.parseInt(st.nextToken()); 
		}
		
		for(int i=2; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int k=1; k<=3; k++) {
				cost[k] = Integer.parseInt(st.nextToken());
			}
			
			result[i][1] = cost[1] + Math.min(result[i-1][2], result[i-1][3]);
			result[i][2] = cost[2] + Math.min(result[i-1][1], result[i-1][3]);
			result[i][3] = cost[3] + Math.min(result[i-1][1], result[i-1][2]);
		}
		
		System.out.println(Math.min(result[N][3], Math.min(result[N][1], result[N][2])));

	}
}
