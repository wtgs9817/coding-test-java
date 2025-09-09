import java.util.*;
//첫번째 풀이
//두번째 풀이 다시 풀어보기 천천히 다시 생각하면서 문제 해결해보기
class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Word> que = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        int count = 0;
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        que.offer(new Word(begin, 0));
        
        while(!que.isEmpty()) {
            Word wr = que.poll();
            
            if(wr.str.equals(target)) {
                count = wr.count;    
            }
            
            for(int i=0; i<words.length; i++) {
                if(!visited[i]) {
                    if(check(wr.str, words[i])) {
                    que.offer(new Word(words[i], wr.count+1));
                    visited[i] = true; 
                    }     
                }
            }   
        }
        return count;
        
    }
    
    //str1 : 현재 단어
    //str2 : 변경하려는 단어
    public boolean check(String str1, String str2) {
        int count = 0;
        
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }   
        }
        
        if(count == 1) {
            return true;
        }
        
        else {
            return false;
        }
        
        
        
    }
    
    
    public class Word{
        String str;
        int count;
        
        public Word(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
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
    
    */
}