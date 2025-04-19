//두번째 풀이
class Solution {
    public int solution(int a, int b, int n) {
        
        int result = 0;
        
        while(true) {
           int exchange = b * (n/a);
            result += exchange;
            
           n = (n%a) + exchange;
            
            if(n < a) {
                break;
            }
        }
        
        return result;
        
    }
}    
    