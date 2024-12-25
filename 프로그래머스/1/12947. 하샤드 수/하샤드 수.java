class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int result = 0;
        int num = x;
        while(num > 0) {
            result += num % 10;
            num /= 10;
        }
        
        if(x % result == 0) {
            answer = true;
        }
        
        else {
            answer = false;
        }
        
        
        
        return answer;
    }
}