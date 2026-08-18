import java.util.*;

/* 
1 ≤ queue1의 길이 = queue2의 길이 ≤ 300,000
1 ≤ queue1의 원소, queue2의 원소 ≤ 10^9(10억)

pop -> insert (1회)
*/
import java.util.*;
class Solution {
    public int solution(int [] queue1, int[] queue2) {
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        long sum = 0;
        
        long q1Sum = 0;
        long q2Sum = 0;
        for(int n : queue1) {
            q1.offer(n);
            sum += (long) n;
            q1Sum+= (long) n;
        }
        for(int n : queue2) {
            q2.offer(n);
            sum+= (long) n;
            q2Sum+= (long) n;
        }
        if(sum % 2 != 0) return -1;
        
        int cnt = 0;
        int len = 0;
        while((queue1.length * 3) >= len) {
            if(q1Sum == sum/2 && q2Sum == sum/2) break;
            
            if(q1Sum > q2Sum) {
                int n = q1.poll();
                q1Sum -= (long) n;
                q2.offer(n);
                q2Sum += (long) n;
                cnt++;
            }
            else if(q1Sum < q2Sum) {
                int n = q2.poll();
                q2Sum -= (long) n;
                q1.offer(n);
                q1Sum += (long) n;
                cnt++;
            }
            len++;
        }
        if(q1Sum != q2Sum) return -1;
        return cnt;
    }
}