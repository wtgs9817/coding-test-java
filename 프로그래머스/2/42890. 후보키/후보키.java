//복습
import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int rowLen = relation.length;
        int colLen = relation[0].length;
        List<Integer> ck = new ArrayList<>();
        
        for(int mask = 1; mask < (1 << colLen); mask++) {
            boolean flag = false;
            for(int key : ck) {
                if((mask & key) == key) {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            Set<String> set = new HashSet<>();
            for(int i=0; i<rowLen; i++) {
                StringBuilder sb = new StringBuilder();
                for(int c=0; c<colLen; c++) {
                    if((mask & (1 << c)) != 0) sb.append(relation[i][c]).append("/");            
                }
                set.add(sb.toString());
            }
            if(set.size() == rowLen) ck.add(mask); 
        }
        
        return ck.size();
    }
}