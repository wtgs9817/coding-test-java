//두번째 풀이
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] result = new int[n];
        
        for(int i=0; i<n; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
            Arrays.sort(arr);
            
            int cnt = commands[i][2] -1;
            result[i] = arr[cnt];
        }
        
        return result;
    }
}