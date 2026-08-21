/*
players의 길이 = 24
0 ≤ players의 원소 ≤ 1,000
players[i]는 i시 ~ i+1시 사이의 게임 이용자의 수를 나타냄
1 ≤ m ≤ 1,000 -> 서버 한 대로 감당할 수 있는 인원
1 ≤ k ≤ 24 -> 서버 운영 가능 시간
*/
import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        int result = 0;
        int server = 0;
        
        for(int i=0; i<players.length; i++) {
            if(!que.isEmpty() && que.peek()[0] == i) {
                int[] arr = que.poll();
                server -= arr[1];
            }
            
            int s = players[i] / m;
            
            if(s > server) {
               int ns = s - server;
                server += ns;
                result += ns;
                
                que.offer(new int[]{i+k, ns});
            }
        }
        
        return result;
    }
}