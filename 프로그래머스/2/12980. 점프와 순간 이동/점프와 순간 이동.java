import java.util.*;
//k 칸 점프하려면 k 만큼 건전지 소비
// 순간이동 -> 현재까지 온 거리 x2 


public class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = n;
        while(num > 0) {
            
            
            if(num % 2 ==0) {
                num /=2;
            }
            
            else {
                num-=1;
                answer++;
            }
        }
        return answer;
    }
}