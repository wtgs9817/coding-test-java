import java.util.*;

//복습
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> de = new ArrayDeque<>(bridge_length);
        int current = 0;
        int time = 0;
        
        int truck_idx = 0;
        for(int i=0; i<bridge_length; i++) de.offer(0);
        
        while(truck_idx < truck_weights.length) {
            int n = truck_weights[truck_idx];
            current -= de.poll(); 
            
            if(current + n <= weight) {
                de.offer(n);
                current+=n;
                truck_idx++;
            }
            else de.offer(0);
            
            time++;
        }
        
        return time + bridge_length;
        
    }
}