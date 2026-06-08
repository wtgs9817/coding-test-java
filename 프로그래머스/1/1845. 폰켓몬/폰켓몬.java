import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int a = nums.length/2;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) set.add(nums[i]);
        
        int answer = 0;
        if(set.size() >= a) answer = a;
        else answer = set.size();
         
        return answer;
    }
}