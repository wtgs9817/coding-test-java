//다시 풀어보기
class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;

        while (n >= a) {
            int exchange = (n / a) * b; // 교환해서 받을 수 있는 콜라 수
            result += exchange;
            n = (n % a) + exchange; // 남은 병 + 새로 마신 콜라의 병
        }

        return result;
    }
}    
    