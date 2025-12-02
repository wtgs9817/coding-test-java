import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();
        StringBuilder next = new StringBuilder();
        sb.append(s);
        
        int count = 0; //반복 횟수
        int cnt = 0;  // 지운 0의 개수
        while(sb.length() > 1) {
            
            
            for(char c : sb.toString().toCharArray()) {
                if(c =='1') {
                    next.append(c);
                }
                else {
                    cnt++;
                }
            }
        
            int len = next.length();
            sb.setLength(0);
            next.setLength(0);
            sb.append(Integer.toBinaryString(len));
            count++;
        }
        
        answer[0] = count;
        answer[1] = cnt;
        
        return answer;
    }
}