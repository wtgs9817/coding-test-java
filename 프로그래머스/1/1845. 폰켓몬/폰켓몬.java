import java.util.*;
class Solution {
    public int solution(int[] nums) {
        
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
        
        
        
        
        
    }
}