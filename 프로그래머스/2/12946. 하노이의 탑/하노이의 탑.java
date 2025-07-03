import java.util.*;
class Solution {
    static List<int[]> list = new ArrayList<>();
    
    public static void move(int n, int x , int y ) {
        
        if(n > 1) {
            move(n-1, x, 6-x-y);
        }
        list.add(new int[]{x, y});
        
        if(n > 1) {
            move(n-1, 6-x-y, y);
        }      
    }
    
    public int[][] solution(int n) {
        int[][] answer = new int[0][];
        Solution.move(n,1,3);
        answer = list.toArray(new int[0][]);
        
        return answer;
    }
    
   
}