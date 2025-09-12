//첫번째 풀이 - 다시 풀어보기

import java.util.*;
class Solution {
    Map<String, PriorityQueue<String>> graph;
    List<String> airports;
    
    public String[] solution(String[][] tickets) {
        graph = new HashMap<>();
        airports = new ArrayList<>();
        
        int m = tickets.length;
        int n = tickets[0].length;
        
        airports = new ArrayList<>();
        
        for(int i=0; i<m; i++) {
            
            if(!graph.containsKey(tickets[i][0])) {
                graph.put(tickets[i][0], new PriorityQueue<>());
            }
            
            graph.get(tickets[i][0]).add(tickets[i][1]);
        }
        
        dfs("ICN");
        Collections.reverse(airports);
        String[] answer = airports.toArray(new String[0]);
        
        return answer;
    }
    
    
    public void dfs(String airport) {
        PriorityQueue<String> pq = graph.get(airport);
        
        while(pq != null && !pq.isEmpty()) {
            String airport2 = pq.poll();
            dfs(airport2);
               
        }
        
        airports.add(airport); 
        
    }
}