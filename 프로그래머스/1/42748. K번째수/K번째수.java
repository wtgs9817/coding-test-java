import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        
        int count = 0;
        for(int i=0; i<commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(arr);
            int idx = commands[i][2] -1;
            
            answer[count]  = arr[idx]; 
            count++;
            
        }
        
        
        return answer;
    }
}