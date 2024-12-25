import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] list = Long.toString(n).split("");
        
        Arrays.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(String str : list ) sb.append(str);
        
        answer = Long.parseLong(sb.reverse().toString());
        
        
        
        
        return answer;
    }
}