import java.util.*;

//복습
class Solution {
    
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> lq = new LinkedList<>(); 
        
        for(String[] arr : tickets) {
            String fr = arr[0];
            String to = arr[1];
            
            if(map.get(fr) == null) {
                map.put(fr, new PriorityQueue<>());
                map.get(fr).add(to);
            }
            else map.get(fr).add(to);
        }
        
        dfs("ICN", map, lq);
        return lq.toArray(new String[0]);
        
        
    }
    public void dfs(String airport, Map<String, PriorityQueue<String>> map, LinkedList<String> lq) {
        PriorityQueue<String> que = map.get(airport);
        
        while(que != null && !que.isEmpty()) {
            String airport2 = que.poll();
            dfs(airport2, map, lq);
        }
        
        lq.addFirst(airport);
    }
}