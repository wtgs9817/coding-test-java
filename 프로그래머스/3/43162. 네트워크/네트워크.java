class Solution {
    static int n2 = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int result = 0;
        n2 = n;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, visited, computers);
                result++;
            }
        }
        
        return result; 
    }
    
    static void dfs(int num, boolean[] visited, int[][] com) {
        
        for(int i=0; i<n2; i++) {
            if(i != num && !visited[i] && com[num][i] == 1) {
                visited[i] = true;
                dfs(i, visited, com);
            }
        }
        
    }
}