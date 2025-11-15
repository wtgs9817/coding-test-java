import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	N개의 랜선 만들어야 됨.
	K개 랜선은 길이 제각각 
	랜선을 모두 N개의 같은 길이로 만들려고 함.
	K에서 잘라서 만드려고 하는데 만들고 남은 길이는 버림
	이런 과정을 거쳐서 만들 수 있는 최대 N개의 랜선을 구하셈
	
	*/
	
	public static int K; //갖고 있는 랜선 수
	public static int N; //필요 랜선
	public static long[] arr;
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new long[K];
		long max = 0;
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long answer = check(max);
		System.out.println(answer);
		
	}
	
	public static long check(long max) {
		long low = 1;
		long high = max;
		long answer = 0;
		
		while(low <= high) {
			long mid = (low + high)/2;
			long cnt = 0;
			
			for(int i=0; i<K; i++) {
				cnt = cnt + (arr[i]/mid);
			}
			
			if(cnt < N) {
				high = mid - 1;
			}
			else {
				answer = mid;
				low = mid + 1;
			}	
		}
		return answer;
	}
}