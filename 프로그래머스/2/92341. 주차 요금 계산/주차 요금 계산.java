import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> in = new HashMap<>();
        Map<String, Integer> total = new TreeMap<>();
        
        for(String arr : records) {
            String[] str = arr.split(" "); 
            
            if(str[2].equals("IN")) {
                String[] t = str[0].split(":");
                int h = Integer.parseInt(t[0]);
                int m = Integer.parseInt(t[1]);
                
                int time = (h * 60) + m;
                in.put(str[1], time);
                if(!total.containsKey(str[1]))  total.put(str[1], 0);       
            }
            else {
                String[] out = str[0].split(":");
                int h = Integer.parseInt(out[0]);
                int m = Integer.parseInt(out[1]);
                
                int outT = (h * 60) + m;
                int inT = in.get(str[1]);
                
                int time = outT - inT;
                total.put(str[1], total.get(str[1]) + time);
                in.put(str[1], -1);
            }
        }
        
        for(String key : in.keySet()) {
            if(in.get(key) >= 0) {
                int time = ((23 * 60) + 59) - in.get(key);
                total.put(key, total.get(key) + time);
                in.put(key, -1);
            }
        }
        
        int[] result = new int[total.size()];
        int cnt = 0;
        for(String key : total.keySet()) {
            if(total.get(key) >= fees[0]) {
                int up = (int) Math.ceil((double) (total.get(key) - fees[0])/fees[2]);
                result[cnt++] = fees[1] + (up * fees[3]);
            }
            else result[cnt++] = fees[1];
        }
        
        return result;
    }
}