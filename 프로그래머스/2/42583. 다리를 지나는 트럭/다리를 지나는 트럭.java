import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0; i<bridge_length; i++) {
            que.add(0);
        }
        
        int cnt = 0;
        int truckWeight = 0;
        while(cnt < truck_weights.length || truckWeight > 0) {
            int x = que.poll();
            truckWeight-=x;
            
            if(cnt < truck_weights.length && truckWeight + truck_weights[cnt] <= weight ) {
                que.add(truck_weights[cnt]);
                truckWeight += truck_weights[cnt];
                cnt++;
            }
            else {
                que.add(0);   
            }
            time++;
                     
        }
        return time;
    }
}