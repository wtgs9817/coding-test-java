class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
            
            if(i % Math.sqrt(i) == 0) { // i 가 제곱수인 경우 약수가 홀수개
                answer -= i;
            }
            else { //아니면 짝수
                answer += i;
            }
            
        }
        
        return answer;
    }
}