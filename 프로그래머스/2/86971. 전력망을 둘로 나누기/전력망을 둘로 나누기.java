import java.util.*;
class Solution {
    
    //전력망을 2개로 분할 두 전력망 모두 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추기
    
    
    public int solution(int n, int[][] wires) {
       ArrayList<Integer>[] list = new ArrayList[n+1];
        int result = Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] nums : wires) {
            int a = nums[0];
            int b = nums[1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int[] nums : wires) {
            int a = nums[0];
            int b = nums[1];
            
            int count = bfs(a, b, 0, n, list);
            int count2 = n - count;
            result = Math.min(Math.abs(count-count2), result);
        }
        
        return result;
    }
    
    static int bfs(int s, int e, int count, int n, ArrayList<Integer>[] list) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        que.offer(s);
        count++;
        visited[s] = true;
        
        while(!que.isEmpty()) {
            int n1 = que.poll();
            
            for(int num : list[n1]) {
                if(num == e) continue;
                
                if(!visited[num]) {
                    visited[num] = true;
                    que.offer(num);
                    count++;
                } 
            }
        }
        return count;
    }
}