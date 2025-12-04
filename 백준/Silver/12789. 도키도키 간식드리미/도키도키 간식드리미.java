import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	
	//다시 풀어봄
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> que = new ArrayDeque<>();
		Stack<Integer> stk = new Stack<>();	
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			que.offer(Integer.parseInt(st.nextToken()));
		}
		int order = 1;
		
		while(!que.isEmpty() || !stk.isEmpty()) {
			
			if(!que.isEmpty() && order == que.peek()) {
				que.poll();
				order++;
			}
			
			else if(!stk.isEmpty() && stk.peek() == order) {
				stk.pop();
				order++;
			}
			
			else if(!que.isEmpty()) stk.push(que.poll());
			
			else {
				System.out.println("Sad");
				return;
			}
		}
		
		System.out.println("Nice");	
	}

}