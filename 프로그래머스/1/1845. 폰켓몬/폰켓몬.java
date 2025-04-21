//첫번째 풀이
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
            
            if(set.size() == nums.length/2) {
                break;
            }
        }
        
        return set.size();
        
        
        
        /* 방법 2
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        
        
        
        for(int i=0; i<nums.length; i++) {
            
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
            }
            
            if(list.size() == nums.length/2) {
                break;
            }
        }
        
        
        return list.size();
        */
        
        
        
        
        
    }
}