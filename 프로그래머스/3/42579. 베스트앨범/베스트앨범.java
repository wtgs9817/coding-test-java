import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();
        int len = plays.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        
        for(int i=0; i<len; i++) {
            String key = genres[i];
            if(!m1.containsKey(key)) {
                m1.put(key, plays[i]);
                m2.put(i, plays[i]);
            }
            else {
                m1.put(key, m1.get(key) + plays[i]);
                m2.put(i, plays[i]);
            }
        }
        ArrayDeque<String> q = new ArrayDeque<>();
        
        for(String k1 : m1.keySet()) {
            int max = 0;
            String nk = "";
            
            for(String k2 : m1.keySet()) {
                if(max < m1.get(k2)) {
                    max = m1.get(k2);
                    nk = k2;
                }
            }
            q.offer(nk);
            m1.put(nk, -1);
        }
        
        while(!q.isEmpty()) {
            String key = q.poll();
            int count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = 0;
            for(int i=0; i<len; i++) {
                if(genres[i].equals(key)) {
                    list.add(i);
                }
            }
            
            for(int n : list) {
                int max = plays[n];
                int idx = n;
                
                for(int n2 : list) {
                    if(max < plays[n2]) {
                        max = plays[n2];
                        idx = n2;
                    }
                }
                result.add(idx);
                count++;
                plays[idx] = -1;
                if(count % 2 == 0) break;
            }
            
        }
        
        int[] answer = new int[result.size()];
        int count = 0;
        for(int n : result) answer[count++] = n;
        
        return answer;

    }
}