import java.util.*;
//k 칸 점프하려면 k 만큼 건전지 소비
// 순간이동 -> 현재까지 온 거리 x2 
//연산 두가지를 사용해서 n까지 도달할 수 있는 최소값 구하기
//두번째 풀이
public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n>0) {
            if(n%2==0) {
                n/=2;
            }
            else {
                n-=1;
                answer++;
            }
        }
        
        
        return answer; 
    }
        
        
        
        
        
        
        
        
        
        
        /*
        
        
        
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
    */
}