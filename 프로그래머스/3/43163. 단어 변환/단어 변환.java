import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        
        Queue<Word> que = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        que.add(new Word(begin, 0));
        
        while(!que.isEmpty()) {
            Word current = que.poll();
            
            if(current.str.equals(target)) {
                return current.step;
            }
            
            for(int i=0; i<words.length; i++) {
                if(!visited[i] && check(current.str, words[i])==1) {
                    que.add(new Word(words[i], current.step+1));
                    visited[i] = true;   
                }
            }          
        }
            
        return 0;
    }
    
    
    public int check(String str, String str2) {
        int count = 0;
        for(int i=0; i<str2.length(); i++) {
            if(str.charAt(i) != str2.charAt(i)) {
                count++;
            }
        } 
        return count;
    }
    
    public class Word {
        String str;
        int step;
        public Word(String str, int step) {
            this.str = str;
            this.step = step;
        }
    }
}