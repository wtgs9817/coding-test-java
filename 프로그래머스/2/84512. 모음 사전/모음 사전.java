//복습
class Solution {
    int count = 0;
    boolean flag = false;
    String[] str = {"A","E","I","O","U"};
    public int solution(String word) {
        dfs("", word);
        return count;
    }
    
    public void dfs(String s, String w) {
        if(flag) return;
        
        if(!s.isEmpty()) {
            count++;
            
            if(s.equals(w)) {
                flag = true;
                return;
            }
            if(s.length() == 5) return;
        }
        for(int i=0; i<str.length; i++) dfs(s + str[i], w);
    }  
    
}