import java.util.*;
//복습

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> d = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++) d.offer(s.charAt(i));
        if(d.peek() == ')') return false;
        int cnt = 0;
        while(!d.isEmpty()) {
            if(cnt < 0) return false;
             char c = d.poll();
            
            if(c == '(') cnt++;
            else cnt--;
        }
        
        if(cnt == 0) return true;
        else return false;
    }
}