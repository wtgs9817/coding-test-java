import java.util.*;

//두번째 풀이

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        String answer = participant[participant.length-1];
        
        for(int i=0; i<participant.length; i++) {
            
            if(i < participant.length-1) {
                if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
                }
            }
            else {
                answer = participant[i];
            }   
        }
        
        
        return answer;
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion) {
            map.put(name, map.get(name)-1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            
            if(value != 0) {
                answer = key;
            }
        }
        
        
        return answer;
        
        */
    }
}