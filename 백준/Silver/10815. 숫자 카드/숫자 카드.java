import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
숫자카드 N개
정수 M개 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지 구해라
숫자 카드의 개수 N(1 ≤ N ≤ 500,000)
숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 
두 숫자 카드에 같은 수가 적혀있는 경우는 없다.


*/
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int left = 0;
			int right = arr.length-1;
			int num = Integer.parseInt(st.nextToken());
			int mid;
			boolean flag = false;
			while(left<=right) {
				mid = (left + right)/2;
				
				if(arr[mid] == num) {
					flag = true;
					break;
				}
			
				else if(arr[mid] < num) left = mid + 1;
				else if(arr[mid] > num) right = mid - 1;
			}
			
			if(flag) System.out.print(1 + " ");
			else System.out.print(0 + " ");
		}
	}

}