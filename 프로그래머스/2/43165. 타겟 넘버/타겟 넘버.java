class Solution {
    static int tar = 0;
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        tar = target;
        int[] arr = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            arr[i] = numbers[i];
        }
        
        dfs(0, arr, 0);
        return answer;
    }
    
    static void dfs(int depth, int[] arr, int result) {
        
        if(depth == arr.length) {
            if(result == tar) answer++;
            
            return;
        }
        
        dfs(depth+1, arr, result + arr[depth]);
        dfs(depth+1, arr, result - arr[depth]);
    }

}