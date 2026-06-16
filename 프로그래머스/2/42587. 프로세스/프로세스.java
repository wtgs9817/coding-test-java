import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int len = priorities.length;
        
        for(int i=0; i<len; i++) q.offer(new int[]{priorities[i], i});
        int count = 0;
        
        while(!q.isEmpty()) {
            boolean flag = true;
            int[] num = q.poll();
            int pr = num[0];
            int idx = num[1];
            
            for(int i=0; i<len; i++) {
                if(priorities[i] > pr) {
                    flag = false;
                    break;
                }
            }
        
            if(!flag) q.offer(num);
            else {
                count++;
                priorities[idx] = -1;
                if(location == idx) return count;
            } 
        }
        return count;
    } 
}