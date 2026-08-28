import java.util.*;
/*
orders 배열의 크기는 2 이상 20 이하 / orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열
각 문자열에는 같은 알파벳이 중복해서 들어있지 않음

course 배열의 크기는 1 이상 10 이하 / course 배열에는 같은 값이 중복해서 들어있지 않음
배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬
만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return
*/
class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<orders.length; i++) {
            char[] chr = orders[i].toCharArray();
            Arrays.sort(chr);
            orders[i] = String.valueOf(chr);
        }
        
        for(int i=0; i<course.length; i++) {
            Map<String, Integer> menu = new HashMap<>();
            int lim = course[i];
            for(int k=0; k<orders.length; k++) {
                dfs(0, "", orders[k], lim, 0, menu);
            }
            int max = 0;
            
            for(String key : menu.keySet()) if(max < menu.get(key)) max = menu.get(key);
            for(String key : menu.keySet()) if(max >= 2 && max == menu.get(key)) list.add(key);
        }
        Collections.sort(list);
        
        String[] result = new String[list.size()];
        int idx = 0;
        for(String key : list) result[idx++] = key;     
        
        return result;
    }
    
    static void dfs(int depth, String key, String order, int lim, int idx, Map<String, Integer> menu) {
        if(depth == lim) {
            if(!menu.containsKey(key)) menu.put(key, 1);
            else menu.put(key, menu.get(key) + 1);
            
            return;
        }
        
        for(int i=idx; i<order.length(); i++) {
            char a = order.charAt(i);
            dfs(depth+1, key+a, order, lim, i+1, menu);
        }
    }
}