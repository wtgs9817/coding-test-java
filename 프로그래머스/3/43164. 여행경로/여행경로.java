import java.util.*;

class Solution {
    static Map<String, PriorityQueue<String>> graph = new HashMap<>();
    static LinkedList<String> answer = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        
        for(String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            
            if(graph.get(from) == null) {
                graph.put(from, new PriorityQueue<>());
                graph.get(from).add(to);
            }
            else graph.get(from).add(to);
        }
        
        dfs("ICN");
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String airport) {
        PriorityQueue<String> des = graph.get(airport);
        
        while(des != null && !des.isEmpty()) {
            String next = des.poll();
            dfs(next);
        }
        answer.addFirst(airport);
    }
}