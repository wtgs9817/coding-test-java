import java.util.*;
/*
players의 길이 = 24
0 ≤ players의 원소 ≤ 1,000
players[i]는 i시 ~ i+1시 사이의 게임 이용자의 수
1 ≤ m ≤ 1,000 --> m명 늘어날 때마다 서버++
1 ≤ k ≤ 24 --> 서버 유지 시간

복습
*/
class Solution {
    public int solution(int[] players, int m, int k) {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        int result = 0;
        int server = 0;
        
        for(int i=0; i<players.length; i++) {
            if(!que.isEmpty() && que.peek()[0] == i) {
                int[] arr = que.poll();
                server-= arr[1];
            }
            
            if(players[i] / m > server) {
                int ns = players[i]/m - server;
                
                server += ns;
                result += ns;
                que.offer(new int[]{i+k, ns});
            }
        }
        
        return result;
    }
}