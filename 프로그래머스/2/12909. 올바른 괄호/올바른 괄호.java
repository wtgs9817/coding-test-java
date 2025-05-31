import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> que = new LinkedList<>();
        
        for(int i=0; i<s.length(); i++) {
            que.add(s.charAt(i));
        }
        
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            if(que.poll() == '('){
                cnt++;
            }

            else {
                cnt--;
                
                if(cnt < 0 ) {
                    answer = false;
                    break;
                }
            }
            
        }
        
        if(cnt != 0 ) { 
            answer = false;
        }    
            
        
          
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}