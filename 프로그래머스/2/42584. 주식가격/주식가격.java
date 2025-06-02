import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stk = new Stack<>();
        int n = prices.length;
        
        for(int i=0; i<n; i++) {
            
            while(!stk.isEmpty() && prices[i] < prices[stk.peek()]) {
                int idx = stk.pop();
                answer[idx] = i - idx;
            }
            
            stk.push(i);
        }
        
        while(!stk.isEmpty()) {
            int idx = stk.pop();
            answer[idx] = n - 1 - idx;
            
            }
        
        return answer;
    }
}