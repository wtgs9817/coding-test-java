//복습

import java.util.*;
class Solution {
    static Map<String, PriorityQueue<String>> ap = new HashMap<>();
    static List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets)    {
        
        for(String[] s : tickets) {
            if(!ap.containsKey(s[0])) ap.put(s[0], new PriorityQueue<>());
            
            ap.get(s[0]).offer(s[1]);
        }
        
        dfs("ICN");
        Collections.reverse(result);
        String[] rs = new String[result.size()];
        int cnt = 0;
        
        for(String s : result) rs[cnt++] = s;
        
        return rs;
    }
    
    static void dfs(String airport) {
        PriorityQueue<String> fap = ap.get(airport);
        
        while(fap != null && !fap.isEmpty()) {
            String a = fap.poll();
            dfs(a);
        }
        
        result.add(airport);
    }
}