import java.util.*;

// 두번째 풀이 
class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = 0;
        
        for(int i=0; i<len; i++) {
            Stack<Character> stk = new Stack<>();
            String str = s.substring(i) + s.substring(0,i);
            boolean flag = true;
            int count = 0;
            
            
            for(int k=0; k<len; k++) {
                if(str.charAt(k) == '(' || str.charAt(k) == '{' || str.charAt(k) == '[') {
                    stk.push(str.charAt(k));
                    count++;
                }
                
                else {
                    if(count > 0) {
                        char ch = stk.pop();
                        if(ch == '(') {
                            if(str.charAt(k) == ')') {
                                count--;    
                            }
                            else {
                                flag = false;
                            }
                            
                        }
                        
                        if(ch == '[') {
                            if(str.charAt(k) == ']') {
                                count--;   
                            }
                            else {
                                flag = false;
                            }
                        }
                        
                        if(ch == '{') {
                            if(str.charAt(k) == '}') {
                                count--;
                            }
                            else {
                                flag = false;
                            }
                        }
                        
                        
                    }
                    else {
                        flag = false;
                    }
                }
                if(!flag) break;
            }
            
            if(flag && stk.isEmpty()) answer++;
        }
        
        
        
        
        return answer;
        
        
        
        /*
        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            boolean flag = true;
            Stack<Character> stk = new Stack<>();
            String str = s.substring(i) + s.substring(0,i);
            for(int k=0; k<s.length(); k++) {
                if(str.charAt(k)=='(' || str.charAt(k) == '{' || str.charAt(k) == '[') {
                    stk.push(str.charAt(k));                    
                }
                
                else {
                    if(stk.isEmpty()) {
                        flag = false;
                        break;
                    }
                    
                    char c = stk.pop();
                    if(c == '[' && str.charAt(k) == ']') {
                        flag = true;
                    }
                    else if(c == '{' && str.charAt(k) == '}') {
                        flag = true;
                    }
                    else if(c == '(' && str.charAt(k) == ')') {
                        flag = true;
                    }
                    
                    else {
                        flag = false;
                        break;
                    }             
                }
              
            }
            if(stk.isEmpty() && flag == true) {
                answer++;
            }
                     
        }
        
        return answer;
        
        */
        }
    }
