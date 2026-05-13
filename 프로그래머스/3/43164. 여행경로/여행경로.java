import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for(int i=0; i<tickets.length; i++) {
            String[] str = tickets[i];
            String from = str[0];
            String to = str[1];
            
            if(map.get(from) == null) {
                map.put(from, new PriorityQueue<>());
                map.get(from).offer(to);
            }
            else map.get(from).offer(to);    
        }
        LinkedList<String> list = new LinkedList<>();
        dfs("ICN", map, list);  
        String[] str = new String[list.size()];
        int cnt = 0;
        for(String air : list) {
            str[cnt++] = air;
        }
        
        return str;
    }
    
    static void dfs(String airport, Map<String, PriorityQueue<String>> map, LinkedList<String> list) {
        
        PriorityQueue<String> q = map.get(airport);
        
        while(q != null && !q.isEmpty()) {
            String air = q.poll();
            dfs(air, map, list);
        }
        
        list.addFirst(airport);
    }
}