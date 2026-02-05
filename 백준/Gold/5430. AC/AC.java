import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while(cnt < N) {
			ArrayDeque<Integer> que = new ArrayDeque<>();
			StringBuilder sb = new StringBuilder();
			
			String method = br.readLine();
			int len = Integer.parseInt(br.readLine());
			String s = br.readLine();
			
			if(len > 0) {
				String[] sarr = s.substring(1, s.length()-1).split(",");
				for(String str : sarr) {
					que.offer(Integer.parseInt(str));
				}
			}
			
			boolean flag = false;
			boolean error = false;
			
			for(int i=0; i<method.length(); i++) {
				
				if(method.charAt(i) == 'R') flag = !flag;
				else {
					if(que.isEmpty()) {
						error = true;
						sb.append("error");
						break;
					}
					
					if(flag) que.pollLast();
					else que.pollFirst();
				}
			}
			
			if(error) System.out.println(sb);
			else {
				sb.append("[");
				while(!que.isEmpty()) {
					sb.append(flag ? que.pollLast() : que.pollFirst());
					if(!que.isEmpty()) sb.append(",");
				}
				sb.append("]");

				System.out.println(sb);
			}
			cnt++;
			
		}
	}
}