// 첫번째 풀이

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] s = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        List<Integer> list = new ArrayList<>();
        int[] score = new int[s.length];
        
        for(int i=0; i<s.length; i++) {
            int count = 0;
            for(int k =0; k<answers.length; k++) {
                if(answers[k] == s[i][k % s[i].length]) {
                    count++;
                }
            }
            score[i] = count;
        }
        
        int maxCount = Math.max(score[0], Math.max(score[1], score[2]));
        
        for(int i=0; i<score.length; i++) {
            if(score[i] == maxCount) {
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
        
        
    }
    
   
    
    
    
    
    
}