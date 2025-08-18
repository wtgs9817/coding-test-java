import java.util.*;

//첫번째 풀이 많이 연습해봐야 할듯 많이 부족함.

class Solution {
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        dfs("", numbers);
        
        int count = 0;
        for(int num : set) {
            if(primeCheck(num)) {
                count++;
            }
        }
        
        return count;
        
    }
    
    public static void dfs(String currentStr, String numbers) {
        
        if(!currentStr.isEmpty()) {
            int num = Integer.parseInt(currentStr);
            set.add(num);
        }
        
        for(int i=0; i<numbers.length(); i++) {
            
            if(!visited[i]) {
                visited[i] = true;
                dfs(currentStr + numbers.charAt(i), numbers);
                visited[i] = false;
            } 
        }
    }
    
    public static boolean primeCheck(int num) {
        
        
        if(num < 2) {
            return false;
        }
        
        for(int i=2; i<= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            } 
        }
        
        return true;
    }
    
    
    
    
    
   
}