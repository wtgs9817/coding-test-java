class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() == 4 || s.length() == 6) {
            for(char c : s.toCharArray()) {
                if(!Character.isDigit(c)) {
                    answer = false;
                }
                
            }                
        }
        
        else {
            answer = false;
        }
        
        
        
        
        
        
        
        /*  예외는 비정상적인 상황에서만 사용해야한다. 이런식으로 해결하는 건 지양해야 함.
        if(len == 4 || len == 6) {
                   
        try {
            int a = Integer.parseInt(s);
            answer = true;
        }
        
        catch(Exception e) {
            answer = false;
        }
     }
        else {
            answer = false;
            
        }
           */
        
        
        
        return answer;
    }
}