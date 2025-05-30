import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[speeds.length];
        List<Integer> list = new ArrayList<>();
        int flag =-1;
        
        int front = 0;
        int count = 1;
        for(int i=0; i< speeds.length; i++) {
            
            int num = 100 - progresses[i];
            arr[i] = (num + speeds[i]-1) / speeds[i];
            
            if(i >= 1) {
                if(arr[front] >= arr[i]) {
                    count++;
                }
                else {
                    list.add(count);
                    count =1;
                    front = i;
                }
            }  
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        
        count = 0;
        for(int a : list) {
            answer[count] = a;
            count++;
        }
        
        
        
        return answer;
    }
}