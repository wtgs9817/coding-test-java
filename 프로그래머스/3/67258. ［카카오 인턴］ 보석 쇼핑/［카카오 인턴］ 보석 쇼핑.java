import java.util.*;
/*
gems 배열의 크기는 1 이상 100,000 이하
gems 배열 -> 1번부터 순서대로 보석이름 저장
gems 배열의 각 원소는 길이가 1 이상 10 이하인 알파벳 대문자로만 구성된 문자열

복습
*/
class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        int len = gems.length;
        int mlen = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        for(int i=0; i<len; i++) set.add(gems[i]);
         
        int start = 0;
        int end = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        while(true) {
            if(map.size() == set.size()) {
                if(mlen > end - start) {
                    mlen = end - start;
                    
                    result[0] = start + 1;
                    result[1] = end;
                }
                String str = gems[start];
                if(map.get(str) - 1 > 0) map.put(str, map.get(str) - 1);
                else map.remove(str);
                
                start++;
            }
            
            else if(end >= len) break;
            else {
                String str = gems[end++];
                if(!map.containsKey(str)) map.put(str, 1);
                else map.put(str, map.get(str) + 1);
            }
        }
        
        return result;
    }
}