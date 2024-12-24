class Solution {
    public int solution(int n) {
        if(n < 0 && n > 3000) {
            return 0;
        }
        int answer = 0;
        
        for(int i=1; i<=n/2; i++) {
            if(n%i==0) {
                answer += i;
            }
        }
        
        
        
        return answer + n;
    }
}