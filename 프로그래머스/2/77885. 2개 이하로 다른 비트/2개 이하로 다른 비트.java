//복습
class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        int cnt = 0;
        
        for(long n : numbers) {
            if(n % 2 == 0) result[cnt++] = n+1;
            else {
                int idx = -1;
                int num = 0;
                while((n & (1L << num)) != 0) num++;
                result[cnt++] = (n | (1L << num)) & ~(1L << num-1);
            }  
        }
        return result;
    }
}