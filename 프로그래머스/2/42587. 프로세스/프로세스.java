import java.util.*;

//첫번째 다시 풀어봐야 할 듯
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        
        
        for(int i=0; i<priorities.length; i++) {
            int[] idx = new int[2];
            idx[0] = i;
            idx[1] = priorities[i];
            
            que.add(idx);
        }
        
        while(!que.isEmpty()) {
            int[] a = que.poll();
            boolean flag = false;
            
            
            for(int[] arr : que) {
                if(a[1] < arr[1]) {
                    flag = true;
                }
            }
            
            if(flag) {
                que.add(a);
            }
            else {
                answer++;                
                if(a[0] == location) return answer;
            }
            
        }    
            
        return answer;
    }
}