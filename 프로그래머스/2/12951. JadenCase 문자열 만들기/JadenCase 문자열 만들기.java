import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        
        for(char c : s.toCharArray()) {
            if(start) {
                sb.append(Character.toUpperCase(c));
            }
            else {
                sb.append(Character.toLowerCase(c));
            }
            
            start = (c == ' ');
        }
        
        return sb.toString();
        
    }
}