import java.util.*;
//복습
class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, set, "", visited);
        
        return set.size();
    }
    
    static void dfs(String numbers, HashSet<Integer> set, String str, boolean[] visited) {
        if(!str.isEmpty()) {
            int n = Integer.parseInt(str);
            if(isPrime(n)) set.add(n);
        }

        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(numbers, set, str+numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
        
        
    }
    
    static boolean isPrime(int num) {
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num%2 == 0) return false;
        
        for(int i=3; i*i <= num; i+=2) {
            if(num%i==0) return false;
        }
        return true;
    }
}