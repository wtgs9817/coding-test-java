//첫번째 큐로 풀이
//두번째 스택으로 풀이
//세번째 풀이도 스택
//네번째 풀이
//5번째 풀이
import java.util.*;
class Solution {
    boolean solution(String s) {
    Stack<Character> stk = new Stack<>();
    
    
        
    for(char a : s.toCharArray()) {
        if(a == '(') {
            stk.push(a);
        }
        
        else {
            if(stk.isEmpty()) {
                return false;
            }
            stk.pop();
        }
    }
        
    return stk.isEmpty();
    
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        Stack<Character> stk = new Stack<>();
        boolean answer = false;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stk.push(s.charAt(i));
            }
            else {
                if(stk.isEmpty()) {
                    answer = false;
                    break;
                }
                stk.pop();
                answer = true;
            }            
        }
        
        if(!stk.isEmpty()) {
            answer = false;
        }
        */
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        boolean answer = true;
        //Queue<Character> que = new LinkedList<>();
        Stack<Character> stk = new Stack<>();
        
        int cnt = 0;
        
        for(int i=0; i<s.length(); i++) {
            
            char a = s.charAt(i);
            
            if(a == '(') {
                answer =true;
                cnt++;
                stk.push(a);
            }
            
            else {
                if(cnt <= 0) {
                    answer = false;
                    break;
                }
                else {
                    stk.pop();
                    cnt--;   
                }
            }            
        }
        
        if(cnt != 0) {
            answer = false;
        }
        
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        for(int i=0; i<s.length(); i++) {
            que.add(s.charAt(i));
        }
        
        
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
        
        */
        /*
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stk.push(c);
            }
            else {
                if(stk.isEmpty()) {
                    answer = false;
                    break;
                }
                stk.pop();
            }
        }
        
        if(!stk.isEmpty()) {
            answer = false;
        }
        
        
        
          
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
        */
    }
}