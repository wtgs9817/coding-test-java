import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 최대한 카드의 합을 크게 만드는 게임
	 각 카드는 양의 정수 
	 n장의 카드를 숫자 보이게 바닥에 놓고, m을 외치면 
	 플레이어가 제한된 시간 안에 n장의 카드 중 3개를 골라 합이 m을 넘지않으면서 최대한 m에 근접하게
	 
	 첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)
	  
	  
	 
	 */
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[num];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int answer = 0;
		boolean flag = true;
		for(int i=0; i<num; i++) {
			
			for(int k=i+1; k<num; k++) {
				
				for(int z=k+1; z<num; z++) {
					int total = arr[i]+arr[k]+arr[z];
					
					if(total ==  m) {
						answer = m;
						flag = false;
					}
					
					if(total < m) {
						answer = Math.max(answer, total);
					}	
				}
				if(!flag) break;
			}
		}
		
		System.out.println(answer);
		
	}

}