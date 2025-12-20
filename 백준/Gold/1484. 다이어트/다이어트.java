import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int n1 = 1;  //생각하는 몸무게
		int n2 = 2;  //현재 몸무게
		List<Integer> list = new ArrayList<>();
		
		while(n1 < n2) {
			int ans = n2*n2 - n1*n1;
			
			if(ans == N) {
				list.add(n2);
				n2++;
				n1++;
			}
			else if(ans < N) {
				n2++;
			}
			else n1++;
		}
		
		if(list.isEmpty()) System.out.println(-1);
		else {
			for(int a : list) System.out.println(a);
		}
	}

}
