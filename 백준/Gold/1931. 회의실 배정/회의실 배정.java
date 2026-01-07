import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] meetings = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken()); // 회의 시작시간
			meetings[i][1] = Integer.parseInt(st.nextToken()); // 회의 종료시간
		}
		
		//끝나는 시간대로 정렬  같으면 작은 순으로
		Arrays.sort(meetings, (a,b) -> {
			if(a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});
		
		int count = 0;
		int end = 0;
		
		for(int[] meeting : meetings) {
			if(end <= meeting[0]) {  //이전 종료 시간 <= 시작 시간
				end = meeting[1];
				count++;
			}
		}
		System.out.println(count);
	}
}
