import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Integer[] BB = new Integer[B.length];
        
        for(int i=0; i<B.length; i++) {
            BB[i] = B[i];
        }
        
        Arrays.sort(BB, Collections.reverseOrder());
        
        int answer = 0;
        for(int i=0; i<A.length; i++) {
            answer += (A[i] * (int) BB[i]);
        }

        return answer;
    }
}