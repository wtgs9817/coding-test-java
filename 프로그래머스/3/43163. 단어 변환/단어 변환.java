import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] arr = new int[words.length];
        
        for(int i=0; i<words.length; i++) {
            int cnt = 0;
            for(int k=0; k<begin.length(); k++) {
                if(begin.charAt(k) == words[i].charAt(k)) {   
                    cnt++;
                }
            }
            if(cnt == begin.length()-1 ) {
                System.out.println(words[i]); 
                que.offer(i);
                arr[i] = 1;
                if(target.equals(words[i])) return arr[i];
            }
        }
        
        while(!que.isEmpty()) {
            int idx = que.poll();
            
            for(int i= 0; i<words.length; i++) {
                int cnt = 0;
                for(int k=0; k<begin.length(); k++) {
                    if(words[idx].charAt(k) == words[i].charAt(k)) cnt++;
                }
                if(arr[i] == 0 && cnt == begin.length()-1) {
                    que.offer(i);
                    arr[i] = arr[idx] + 1;
                    if(words[i].equals(target)) return arr[i];
                }
            }
        }
        
        return 0;
    }
}