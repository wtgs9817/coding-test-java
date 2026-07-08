import java.util.*;
/*

[0,0,0,0,0]
[0,0,1,0,3]
[0,2,5,0,1]
[4,2,4,4,2]
[3,5,1,3,1]

*/
class Solution {
    public int solution(int[][] board, int[] moves) {
        Deque<Integer> que = new ArrayDeque<>();
        int result = 0;
        
        for(int i=0; i<moves.length; i++) {
            int idx = moves[i] - 1;
            boolean flag = true;
            int num = 0;
            
            for(int k=0; k<board[0].length; k++) {
                int n = board[k][idx];
                
                if(n != 0) {
                    num = n;
                    board[k][idx] = 0;
                    break;
                }
            }
            if(num == 0) continue;
            
            if(!que.isEmpty()) {
                if(que.peekFirst() == num) {
                    System.out.println(que.pop());
                    result+=2;
                    flag = false; 
                }  
            }
            if(flag) que.push(num);
        }
        
        return result;
    }
}