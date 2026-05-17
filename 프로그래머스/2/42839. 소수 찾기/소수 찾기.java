import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<Integer>();
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, visited, "", set);
        
        return set.size();
    }
    
    void dfs(String numbers, boolean[] visited, String str, Set<Integer> set) {
        if(!str.isEmpty()) {
            int n = Integer.parseInt(str);
            if(isPrime(n)) set.add(n);
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(numbers, visited, str + numbers.charAt(i), set);
                visited[i] = false;
            }
        }
        
    }
    
    boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false; 
        }
        return true;
    }
}