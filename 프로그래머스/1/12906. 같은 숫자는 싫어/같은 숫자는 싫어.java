import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i =0; i<arr.length; i++) {
        
            if(i==0 || arr[i-1] != arr[i]) {
                list.add(arr[i]);        
            }
        }
        
        int[] answer = list.stream().mapToInt(x -> x).toArray();
        return answer;
               
    }
}