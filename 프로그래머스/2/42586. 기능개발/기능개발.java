//첫번째 풀이 다음 풀이는 자료구조를 생각하며 풀어보자
// 두번째 풀이 큐를 이용해서 풀어봄
//세번째 풀이도 큐로 품
//네번째 풀이 디큐
//다섯번째 풀이

//여섯번째 풀이
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new ArrayDeque<>();
        int count = 1;
        int num = (int) Math.ceil((100.0 -progresses[0])/speeds[0]); 
        
        que.offer(num);
        
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<speeds.length; i++) {
            int arr = que.peek();
            
            int num2 = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            
            if(arr < num2) {
                que.poll();
                list.add(count);
                count = 1;
                que.offer(num2);      
            }
            
            else {
                count++;
            }
        }
        
        list.add(count);
        
        
        
        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int a : list) {
            answer[cnt] = a;
            cnt++;
        }
        
        return answer;
    }
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        Deque<Integer> que = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
     
        for(int i=0; i<speeds.length; i++) {
            int n1 = (100 - progresses[i]);
            
            int result = (n1 + speeds[i]-1) / speeds[i];
            
            if(que.isEmpty() || que.peekFirst() >= result) {
                que.addLast(result);
            }
            else {
                list.add(que.size());
                que.clear();
                
                que.addLast(result);
            }
        }
        
        list.add(que.size());
        
        int[] answer = new int[list.size()];
        
        int cnt = 0;
        for(int n : list) {
            answer[cnt++] = n;
        }
        
        return answer;
        
        */
        
        
        /*
        
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int n = speeds.length;
        int cnt = 1;
        
        for(int i=0; i<n; i++) {
            int num = 100 - progresses[i];
            int result = (num + speeds[i] -1) / speeds[i];
            if(!deque.isEmpty()) {
                if(deque.peekFirst() >= result) {
                    cnt++;
                }
                else {
                    deque.clear();
                    list.add(cnt);
                    cnt = 1;
                }
            }    
            deque.addLast(result);
        }
        
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        int count = 0;
        for(int a : list) {
            answer[count] = a;
            count++;
        }
        
       // return answer;
        
        
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        List<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        int cnt = 1;
        
        
        for(int i=0; i<speeds.length; i++) {
            int x = (100 - progresses[i] + speeds[i] -1) / speeds[i];
            
            if(!que.isEmpty() ) {
                if(que.peek() >= x) {
                    cnt++;
                }
                else {
                    list.add(cnt);
                    cnt = 1;
                    que.clear();
                }
                
            }
            que.add(x);
            
        }
        
        list.add(cnt);
        int idx = 0;
        
        int[] answer = new int[list.size()];
        for(int a : list) {
            answer[idx] = a;
            idx++;
        }
        
        
        */
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        List<Integer> list = new ArrayList<>();
        
        int front = 0;
        int count = 1;
        for(int i=0; i< speeds.length; i++) {
            
            int num = 100 - progresses[i];
            arr[i] = (num + speeds[i]-1) / speeds[i];
            
            if(i >= 1) {
                if(arr[front] >= arr[i]) {
                    count++;
                }
                else {
                    list.add(count);
                    count =1;
                    front = i;
                }
            }  
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        
        count = 0;
        for(int a : list) {
            answer[count] = a;
            count++;
        }
    
        return answer;
        */
        /*
        Queue<Integer> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        
        
        
        for(int i=0; i<speeds.length; i++) {
            int num = 100 - progresses[i];
            arr[i] = (num + speeds[i]-1) / speeds[i];
            
            if(!que.isEmpty() && que.peek() < arr[i]) {
                list.add(que.size());
                que.clear();
            }
            
            que.offer(arr[i]);
            
            
            }
        
        list.add(que.size());
        
        
        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int a : list) {
            answer[cnt++] = a; 
        }
        
        return answer;
    */
    
}