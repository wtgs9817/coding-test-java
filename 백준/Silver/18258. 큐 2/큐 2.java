import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> que = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case "push":
					int num = Integer.parseInt(st.nextToken());
					que.offer(num);
					break;
				
				case "pop":
					if(que.isEmpty()) sb.append("-1").append("\n");
					else sb.append(que.poll()).append("\n");
					break;
				case "size":
					sb.append(que.size()).append("\n");
					break;
					
				case "empty":
					if(que.isEmpty()) sb.append("1").append("\n");
					else sb.append("0").append("\n");
					break;
					
				case "front":
					if(que.isEmpty()) sb.append("-1").append("\n");
					else sb.append(que.peek()).append("\n");
					break;
					
				case "back":
					if(que.isEmpty()) sb.append("-1").append("\n");
					else sb.append(que.peekLast()).append("\n");
					break;
			}
		}
		
		System.out.println(sb);
	}

}