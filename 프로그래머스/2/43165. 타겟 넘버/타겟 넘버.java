//첫번째 풀이 다시 풀어보기
//두번째 풀이
class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, numbers, target);
        return count;
        
    }
    
    
    public static void dfs(int a, int depth, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(a == target) {
                count++;    
            }
            return;
        }
        
        dfs(a + numbers[depth], depth+1, numbers, target);
        dfs(a - numbers[depth], depth+1, numbers, target);
                
    }
    
    
    
    
    
    
    
    
    
    
    /*
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        int len = numbers.length;
        
        dfs(0,0, numbers, target);
        
        return count;
        
    }
    
    public static void dfs(int depth, int sum, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                count++;
            }
            return;
        }
        
        dfs(depth+1, sum + numbers[depth], numbers, target);
        dfs(depth+1, sum - numbers[depth], numbers, target);
        
        
    }
    
    */
}