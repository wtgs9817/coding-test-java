import java.util.*;
/*
gems 배열의 크기는 1 이상 100,000 이하 / gems 배열의 각 원소는 진열대에 나열된 보석
gems 배열에는 1번 진열대부터 진열대 번호 순서대로 보석이름이 차례대로 저장
gems 배열의 각 원소는 길이가 1 이상 10 이하인 알파벳 대문자로만 구성된 문자열
*/
class Solution {
    public int[] solution(String[] gems) {
        int[] result = new int[2];
        HashSet<String> set = new HashSet<>();
        int len = gems.length;
        int mlen = Integer.MAX_VALUE;
        
        for(int i=0; i<len; i++) set.add(gems[i]);
        
        HashMap<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        
        while(true) {
            if(map.size() == set.size()) {
                String a = gems[start];
                
                if(mlen > end - start) {
                    mlen = end - start;
                                 
                    result[0] = start + 1;
                    result[1] = end; 
                }
                
                if(map.get(a) - 1 > 0) map.put(a, map.get(a) - 1);
                else map.remove(a);
                start++;
            }
            
            else if(end >= len) break;
            else {
                if(!map.containsKey(gems[end])) map.put(gems[end], 1);
                else map.put(gems[end], map.get(gems[end]) + 1);
                
                end++;
            }
        }
        return result;
    }
}