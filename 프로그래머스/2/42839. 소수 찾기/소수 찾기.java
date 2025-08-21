import java.util.*;

//첫번째 풀이 많이 연습해봐야 할듯 많이 부족함.
//두번째 풀이  
// dfs(num + numbers.charAt(i), numbers); 이 부분 주의 num 에 값을 저장하고 재귀로 넘기면 재귀 끝나고 돌아왔을 때 
// 값이 원복이 안됨.
class Solution {
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        int count = 0;
        
        dfs("", numbers);
        
        for(int n : set) {
            if(check(n)) {
                count++;
            }
        }
         
        return count;
    }
    
    
    public static void dfs(String num, String numbers) {
        
        if(!num.isEmpty()) {
            int n = Integer.parseInt(num);
            set.add(n);
        }
       
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                
                dfs(num + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    public static boolean check(int num) {
        if(num < 2) {
            return false;
        }
        else {
            for(int i=2; i<=Math.sqrt(num); i++) {
                if(num % i == 0) {
                    return false;
                }
            }
            
            return true;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
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
    
    
    */
    
    
   
}