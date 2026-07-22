/*
relation의 컬럼(column)의 길이는 1 이상 8 이하이며, 각각의 컬럼은 릴레이션의 속성을 나타낸다.
relation의 로우(row)의 길이는 1 이상 20 이하이며, 각각의 로우는 릴레이션의 튜플을 나타낸다.
relation의 모든 문자열의 길이는 1 이상 8 이하이며, 알파벳 소문자와 숫자로만 이루어져 있다.
relation의 모든 튜플은 유일하게 식별 가능하다.(즉, 중복되는 튜플은 없다.)
*/

import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int rowLen = relation.length;
        int colLen = relation[0].length;
        List<Integer> ck = new ArrayList<>();
        
        for(int mask = 1; mask < (1 << colLen); mask++) {
            
            //최소성 검사
            boolean flag = true;
            for(int key : ck) {
                //key의 모든 비트가 mask에 포함되어 있다면 최소성 위반
                if((mask & key) == key) {
                    flag = false;
                    break;
                }
            }
            
            if(!flag) continue;
            
            //유일성 검사
            Set<String> set = new HashSet<>();
            for(int r=0; r<rowLen; r++) {
                StringBuilder sb = new StringBuilder();
                for(int c=0; c<colLen; c++) {
                    if((mask & (1 << c)) != 0) sb.append(relation[r][c]).append("/");
                }
                set.add(sb.toString());
                
                if(set.size() == rowLen) ck.add(mask);
            }
        }
        
        return ck.size();     
    }
     
}