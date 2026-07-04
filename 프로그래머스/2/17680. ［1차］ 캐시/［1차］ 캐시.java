import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        
        LinkedList<String> list = new LinkedList<>();
        int time = 0;
        
        for(String city : cities) {
            String ct = city.toLowerCase();
            
            if(list.contains(ct)) {
                time++;
                list.remove(ct);
                list.addLast(ct);
            }
            
            else {
                time+=5;
                
                if(list.size() == cacheSize) list.removeFirst();
                list.addLast(ct);  
            }
        }
        
        return time;
    }
}