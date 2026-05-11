import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] nums = {{1,2,3,4,5},{2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        
        int[] score = new int[3];
        
        for(int i=0; i<3; i++) {
            for(int k=0; k<answers.length; k++) {
                if(answers[k] == nums[i][k % nums[i].length]) score[i]++;
            }
        }
        
        int max = Math.max(score[0], Math.max(score[1],score[2]));
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            if(score[i] == max) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int a : list) answer[cnt++] = a; 
        
        return answer;
    }
 }