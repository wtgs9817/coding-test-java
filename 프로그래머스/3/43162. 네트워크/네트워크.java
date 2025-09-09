//첫번째 풀이 꼭 다시 풀어보기
//두번째 풀이
//세번째 풀이
class Solution {
    int n;
    int[][] computers;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int count = 0;
        
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        
        for(int i=0; i<computers.length; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int num) {
        visited[num] = true;
        
        for(int i=0; i<computers[num].length; i++) {
            if(!visited[i] && computers[num][i] == 1) {
                dfs(i);
            }        
        }        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
    
    int n;
    int[][] computers;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];
        
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs(int num) {
        visited[num] = true;
        
        for(int i=0; i<this.n; i++) {
            if(this.computers[num][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    
    
    
    */
    
    
    
    
    
    /*
    
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
    
    */
    
}