class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int len = Math.max(n, m);
        
        for(int i =1; i<=len; i++) {
            
            if(n % i== 0 && m % i ==0) {
                answer[0] = i;
            }        
        }
        
        answer[1] = (m * n) / answer[0]; 
        
        return answer;
    }
}