import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return 5*cities.length;
        
        List<String> list = new LinkedList<>();
        int time = 0;
        
        for(int i=0; i<cities.length; i++) {
            String s = cities[i].toLowerCase();
            
            if(list.contains(s)) {
                list.remove(s);
                list.addFirst(s);
                time++;
            }
            
            else {
                if(list.size() == cacheSize) list.removeLast();
                list.addFirst(s);
                time+=5;
            }
        }
        
        return time;
    }
}