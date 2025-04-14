import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> set = new HashSet<>();
        
        
        for(int i=0; i<numbers.length; i++) {
            for(int k = i+1; k<numbers.length; k++) {
                set.add(numbers[i] + numbers[k]);   
            }
        }
        
        int[] answer = new int[set.size()];
        int i = 0;
        for(int num : set) {
            answer[i] = num;
            i++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}