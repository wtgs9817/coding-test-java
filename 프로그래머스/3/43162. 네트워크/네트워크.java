//첫번째 풀이 꼭 다시 풀어보기

class Solution {
    int n;
    boolean[] visited;
    int[][] computers;
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.visited = new boolean[this.n];
        this.computers = computers;
        
        int count =0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;    
            }
        }
        
        return count;
    }
    
    public void dfs(int num) {
        
        this.visited[num] = true;
        for(int i=0; i<this.n; i++) {
            if(computers[num][i] == 1 && !this.visited[i]) {
                dfs(i);
            }
        }
    }
    
}