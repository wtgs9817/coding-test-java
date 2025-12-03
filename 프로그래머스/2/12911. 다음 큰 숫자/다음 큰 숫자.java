class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int count = Integer.bitCount(n);
             
        int num = n+1;
        int cnt = 0;
        while(true) {
            cnt = Integer.bitCount(num);
            
            if(cnt == count) {
                answer = num;
                break;
            }
            num++; 
        }
        
        return answer;
    }
}