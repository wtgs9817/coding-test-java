class Solution {
    String[] w = {"A","E","I","O","U"};
    int count = 0;
    int result = 0;
    public int solution(String word) {
        dfs("", word);
        return result;
    }
    
    void dfs(String str, String word) {
        if(str.equals(word)) {
            result = count;
        }
        if(str.length() == 5) return;
        
        for(int i=0; i<5; i++) {
            count++;
            dfs(str + w[i], word);
        }
        if(result != 0) return;
    }
}