
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double result = Math.sqrt(n);
        int result02 = (int) result;
        
        if(result % result02 !=0 ) {
            answer = -1;
        }
        
        else {
            answer = (long) Math.pow(result+1, 2);
        }
        
        return answer;
    }
}