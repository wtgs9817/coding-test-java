import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<numbers.length; i++) {
            for(int k=i+1; k<numbers.length; k++) {
                set.add(numbers[i]+numbers[k]); 
            }   
        }
        
        int[] result = new int[set.size()];
        int cnt = 0;
        for(int num : set) {
            result[cnt] = num;
            cnt++;
        }
        
        Arrays.sort(result);
        
        return result;
       
    }
}