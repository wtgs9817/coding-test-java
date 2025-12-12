import java.util.*;
class Solution  {
    
    public int solution(String s)   {
        int answer = 0;
        Stack<Character> stk = new Stack<>();
        int idx = 0;
        
        while(true) {
            if(idx == s.length()) {
                if(stk.isEmpty()) answer = 1;
                break;
            }
            
            if(stk.isEmpty()) {
                stk.push(s.charAt(idx));
            }
            
            else if(stk.peek() == s.charAt(idx)) {
                stk.pop();
            }
            else {
                stk.push(s.charAt(idx));
            }
            
            idx++;
        }
            

        return answer;
    }
}