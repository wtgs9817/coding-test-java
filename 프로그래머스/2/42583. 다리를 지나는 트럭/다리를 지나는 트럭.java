import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> que = new ArrayDeque<>(bridge_length);
        int time = 0;
        int current = 0;
        
        for(int truck : truck_weights) {
            while(true) {
                if(que.size() == bridge_length) {
                    current -= que.poll();    
                }
                if(current + truck <= weight) {
                    current+=truck;
                    que.offer(truck);
                    time++;
                    break;
                }
                else {
                    que.offer(0);
                    time++;
                }
            }
        }
        
        return time + bridge_length;
    }
}