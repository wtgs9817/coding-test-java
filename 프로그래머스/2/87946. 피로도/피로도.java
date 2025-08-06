//첫번째 풀이 재귀 조금 헷갈림. 하기 전에 좀 더 보고 다시 풀어보면 좋을듯
class Solution {
    
    int maxCount = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons,  maxCount);
        return maxCount;
        
        
    }
    
    public void dfs(int k, int[][] dungeons, int count) {
        this.maxCount = Math.max(this.maxCount, count);
        
        for(int i=0; i<dungeons.length; i++) {
            int required = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(k >= required && !this.visited[i]) {
                visited[i] = true;
                dfs(k - cost, dungeons, count+1);
                visited[i] = false;
            }   
        }  
    }
    
    
    
    
    
    
    
        
    
}