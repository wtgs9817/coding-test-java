import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new ArrayDeque<>();
		Stack<Integer> stk = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		for(int i=0; i<N; i++) {
			que.offer(Integer.parseInt(st.nextToken()));
		}
		int count = 1;
		
		while(!que.isEmpty() || !stk.isEmpty()) {
			
			if(!que.isEmpty() && que.peek() == count) {
				que.poll();
				count++;
			}
			else if(!stk.isEmpty() && stk.peek() == count) {
				stk.pop();
				count++;
			}
			
			else if(!que.isEmpty()) {
				stk.push(que.poll());
			}
			
			else {
				System.out.println("Sad");
				return;
			}
		}
		
		
		System.out.println("Nice");
		
	}
}