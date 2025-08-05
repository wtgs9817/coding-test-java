//세번째 풀이
import java.util.*;

public class Solution {
    
    int cnt = 0;
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            
            if(list.isEmpty() || list.get(list.size() - 1) != arr[i] ) {
                list.add(arr[i]);
            }
        }
        
        int[] result = new int[list.size()];
        int count = 0;
        for(int num : list) {
            result[count++] = num;  
        }
        
        return result;
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            if(list.isEmpty() || list.get(list.size()-1) != arr[i]) {
                list.add(arr[i]);
            }
        }
        
        int[] result = new int[list.size()];
        int cnt =0;
        
        for(int a : list) {
            result[cnt++] = a;
        }
        
        return result;
        */
           
    }
}
