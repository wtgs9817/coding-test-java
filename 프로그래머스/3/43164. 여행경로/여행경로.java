//첫번째 풀이 - 다시 풀어보기
//두번째 풀이 - 한번만 더 
//세번째 풀이 
import java.util.*;
class Solution {
    Map< String, PriorityQueue<String> > map;
    List<String> list;
    
    
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        list = new ArrayList<>();
        
        for(int i=0; i<tickets.length; i++) {
            if(!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], new PriorityQueue<>());
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        
        dfs("ICN");
        
        Collections.reverse(list);
        String[] airports = list.toArray(new String[0]);
        
        
        return airports;
    }
    
    
    public void dfs(String airport) {
        PriorityQueue<String> apts = map.get(airport);
        
        while(apts != null && !apts.isEmpty()) {
            String apt = apts.poll();
            dfs(apt);
        }
        
        list.add(airport);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
    Map<String, PriorityQueue<String>> map;
    List<String> list;
    
    
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        list = new ArrayList<>();
        
        for(int i=0; i<tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            if(!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).add(to);
        }
        dfs("ICN");
        
        Collections.reverse(list);
        String[] answer = list.toArray(new String[0]);
        
        return answer;
    }
    
    
    
    public void dfs(String airport) {
        PriorityQueue<String> pq = map.get(airport);
        
        while(pq != null && !pq.isEmpty()) {
            String ap = pq.poll();
            dfs(ap);
        }
        
        list.add(airport);   
    }
    
    */
    
    
    
    
    
    
    
    
    
    /*
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
    
    */
}