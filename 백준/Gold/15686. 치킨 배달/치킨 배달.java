import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
(1,1) 부터 시작

치킨거리 : 집에서 가장 가까운 치킨집 사이의 거리 (각각의 집은 치킨 거리 보유)
도시의 치킨 거리 -> 모든 집의 치킨 거리의 합

0 -> 빈 칸 / 1-> 집 / 2 -> 치킨집
*/
public class Main {
	static int N,M;
	static int answer = Integer.MAX_VALUE;
	
	static List<int[]> home = new ArrayList<>();
	static List<int[]> ch = new ArrayList<>();
	static int[][] lens;
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lens = new int[M][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=1; k<=N; k++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == 1) {
					home.add(new int[] {i,k});
				}
				else if(num == 2) {
					ch.add(new int[] {i,k});
				}
			}
		}
		
		chLen(0, 0);
		System.out.println(answer);
	
	}
	
	static void chLen(int start, int depth) {
		if(M == depth) {
			cal();
			return;
		}
		
		for(int i= start; i<ch.size(); i++) {
			int[] a = ch.get(i);
			
			int ax = a[1];
			int ay = a[0];	
				
			lens[depth] = new int[] {ay,ax};
			chLen(i+1, depth+1);
			
		}
	}
	
	static void cal() {
		int sum = 0;
		
		for(int[] a : home) {
			int hx = a[1];
			int hy = a[0];
			
			int min = Integer.MAX_VALUE;
			
			for(int i=0; i<lens.length; i++) {
				int lx = lens[i][1];
				int ly = lens[i][0];
				
				min = Math.min(min, Math.abs(hx - lx) + Math.abs(hy - ly));
			}
			sum += min;
		}
		
		if(answer > sum) answer = sum;	
	}
}
