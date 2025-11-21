import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	public static int[] arr = new int[9];
	public static int[] answer = new int[7];
	public static StringBuilder sb = new StringBuilder();
	
	public static int sum = 0;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		searchHobbit(0, 0);
		System.out.println(sb);
	}
	
	public static boolean searchHobbit(int start, int depth) {
		
		if(depth == 7) {
			if(sum == 100) {
				Arrays.sort(answer);
				for(int i=0; i<7; i++) {
					sb.append(answer[i]).append("\n");
				}
				return true;
			}
			return false;
		}
		
		for(int i=start; i<9; i++) {
				
				
				answer[depth] = arr[i];
				sum+=answer[depth];
				if(searchHobbit(i+1, depth+1)) return true;
				sum-=arr[i];
			}
		return false;
	}
}