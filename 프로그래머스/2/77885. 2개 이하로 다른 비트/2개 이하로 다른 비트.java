/*
1 ≤ numbers의 길이 ≤ 100,000
0 ≤ numbers의 모든 수 ≤ 10^15
x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
*/
class Solution {
    public long[] solution(long[] numbers) {
        long[] arr = new long[numbers.length];
        int cnt = 0;
        for(long num : numbers) {
            if(num % 2 == 0) arr[cnt++] = num+1;
            else {
                int k = 0;
                while((num & (1L << k)) != 0) k++;
                arr[cnt++] = (num | 1L << k) & ~(1L << k-1);
            }
        }
        return arr;
    }
}