/*
1 ≤ numbers의 길이 ≤ 100,000
0 ≤ numbers의 모든 수 ≤ 10^15

*/
class Solution {
    public long[] solution(long[] numbers) {
        int cnt = 0;
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            long a = numbers[i];
            
            if(a % 2 == 0) answer[cnt++] = a+1;
            else {
                long k = 0;
                while((a & (1L << k)) != 0) k++;
                answer[cnt++] = (a | (1L << k)) & ~(1L << (k-1));
            }
        }
        return answer;
    }
}