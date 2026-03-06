import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<int[]> stk = new Stack<>();	
		
		for(int i=0; i<N; i++) {
			while(!stk.isEmpty() && stk.peek()[0] < arr[i]) {
				stk.pop();
			}
			
			if(stk.isEmpty()) sb.append("0 ");
			else sb.append(stk.peek()[1] + 1).append(" ");
			
			stk.push(new int[] {arr[i], i});
		}

		System.out.println(sb);
	}
}
