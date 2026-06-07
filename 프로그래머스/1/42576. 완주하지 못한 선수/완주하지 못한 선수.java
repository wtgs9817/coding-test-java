//복습
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        
        for(int i=0; i<participant.length; i++){
            String key = participant[i];
            if(map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
        }
        
        for(String key : completion) if(map.containsKey(key)) map.put(key, map.get(key) -1);
        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
                break;
            }
        }
            
        return answer;
    }
}