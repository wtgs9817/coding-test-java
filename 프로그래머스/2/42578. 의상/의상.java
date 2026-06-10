import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            String[] arr = clothes[i];
            if(!map.containsKey(arr[1])) {
                map.put(arr[1], 1);
            }
            else {
                map.put(arr[1], map.get(arr[1]) + 1);
            }
        }
        int result = 1;
        for(String key : map.keySet()) {
            int n = map.get(key);
            result *= (n + 1);
        }
        
        return result-1;
    }
}