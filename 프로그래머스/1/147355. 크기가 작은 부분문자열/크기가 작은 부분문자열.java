class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        Long num = Long.parseLong(p);
        
        int cnt =0;
        for(int i=0; i < t.length() - len +1; i++) {
            long num2 = Long.parseLong(t.substring(i,i+len));
            
            if(num >= num2) {
                cnt++;
            }
            
        }
        answer = cnt;
        return answer;
            
        }
        
        
        
    
}