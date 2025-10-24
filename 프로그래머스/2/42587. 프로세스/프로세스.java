import java.util.*;

//첫번째 다시 풀어봐야 할 듯
//두번째 풀이 - 해답을 안보고 맞췄지만 문제 좀 똑바로 읽어야 할 듯. 뻘짓거리로 시간 낭비함.
//두번째 풀이 - 현재 복잡도면에서 코드가 별로임. 다른 풀이들 보면서 공부 후 다시 풀기
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> que = new ArrayDeque<>();
        int len = priorities.length;    
        
        for (int i = 0; i < len; i++) {
            que.offer(new int[]{priorities[i], i});
        }

        int answer = 0;
        int count = 0;

        while (!que.isEmpty()) {
            int[] arr = que.poll();
            boolean flag = true;

            for (int[] num : que) {
                if (arr[0] < num[0]) {
                    flag = false;
                }
            }

            if (!flag) {
                que.offer(arr);
            } else {
                count++;

                if (location == arr[1]) {
                    answer = count;
                    return answer;
                }
            }
        }
        return answer;
    }
    
}
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        
        
        for(int i=0; i<priorities.length; i++) {
            int[] arr = new int[2];
            arr[0] = i;
            arr[1] = priorities[i];
            que.add(arr);
        }
        int count = 0;
        while(!que.isEmpty()) {
            int[] arr1 = que.poll();
            boolean flag = false;
            for(int[] arr2 : que)  {
                
                if(arr1[1] < arr2[1]) {
                    flag = true;
                    break;
                }
            }
            
            if(flag == true) {
                que.add(arr1);
            }
            
            else {
                count++;
                if(arr1[0] == location) {
                    answer= count;
                } 
            }
            
        }
       
        */
        
       
        
       
        
        
        
        
                
       
    
        
        
        
        
    
        
        
        
        
        
        /*
        for(int i=0; i<priorities.length; i++) {
            int[] idx = new int[2];
            idx[0] = i;
            idx[1] = priorities[i];
            
            que.add(idx);
        }
        
        while(!que.isEmpty()) {
            int[] a = que.poll();
            boolean flag = false;
            
            
            for(int[] arr : que) {
                if(a[1] < arr[1]) {
                    flag = true;
                }
            }
            
            if(flag) {
                que.add(a);
            }
            else {
                answer++;                
                if(a[0] == location) return answer;
            }
            
        }    
          */  
  