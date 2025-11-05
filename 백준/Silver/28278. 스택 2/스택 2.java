import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stk = new Stack<>();
		
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			
			if(n==1) {
				int num = Integer.parseInt(st.nextToken());
				stk.push(num);
			}
			
			if(n==2) {
				
				if(stk.isEmpty()) {
					System.out.println(-1);
				}
				else {
					if(stk.isEmpty()) {
						System.out.println(-1);
					}
					else {
						System.out.println(stk.pop());
					}
					
				}
			}
			
			if(n==3) {
				System.out.println(stk.size());
			}
			
			if(n==4) {
				if(stk.isEmpty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			
			if(n==5) {
				if(!stk.isEmpty()) {
					System.out.println(stk.peek());
				}
				else {
					System.out.println(-1);
				}
			}			
		}
	}

} 