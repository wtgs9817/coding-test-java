class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return dfs(k, dungeons, visited, 0);
    }
    
    static int dfs(int piro, int[][] dungeons, boolean[] visited, int count) {
        int max = count;
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && piro >= dungeons[i][0]) {
                visited[i] = true;
                int rmax = dfs(piro - dungeons[i][1], dungeons, visited, count+1);
                max = Math.max(rmax, max);
                
                visited[i] = false; 
            }
        }
        return max;
    }
}