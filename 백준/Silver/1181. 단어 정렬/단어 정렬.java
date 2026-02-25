import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Set<String>[] strArr = new TreeSet[51];
		
		for(int i=1; i<=50; i++) {
			strArr[i] = new TreeSet<>();
		}
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			strArr[str.length()].add(str);
		}
		
		for(int i=1; i<=50; i++) {
			for(String str : strArr[i]) {
				sb.append(str).append("\n");
			}
		}
		System.out.println(sb);
	}
}