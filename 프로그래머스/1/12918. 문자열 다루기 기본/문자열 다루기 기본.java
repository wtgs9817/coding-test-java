class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
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
           
        
        return answer;
    }
}